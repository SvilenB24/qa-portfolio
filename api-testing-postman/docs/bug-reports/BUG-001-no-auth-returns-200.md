# BUG-001: /auth/me returns 200 without Authorization header

## Title
[DummyJSON] [auth] - /auth/me endpoint returns 200 OK and full user profile when accessed without Bearer token

## Severity
High

## Priority
Medium

## Environment
- API: https://dummyjson.com
- Tested via: Postman 12.12 + Newman 6.2.2
- Date: 2026-05-28

## Steps to Reproduce
1. POST https://dummyjson.com/auth/login with valid credentials (emilys / emilyspass)
2. Observe Postman saves session cookies (accessToken, refreshToken)
3. Create new GET request to https://dummyjson.com/auth/me
4. Remove Authorization header completely (Auth Type = No Auth)
5. Send request

## Expected Result
Status `401 Unauthorized` with error message indicating missing/invalid authentication.

## Actual Result
Status `200 OK` returned with full user profile of the previously logged-in user (Emily Johnson).

## Root Cause Analysis
The server appears to accept session cookies as a fallback authentication mechanism, even when the documented Bearer token authentication is not provided. This contradicts the API documentation which states all `/auth/*` protected endpoints require a Bearer token.

## Security Impact
- Session fixation attacks become easier
- Token-based auth assumptions broken in client implementations
- Confusion in negative testing scenarios

## Suggested Fix
Reject `/auth/me` requests that do not contain a valid `Authorization: Bearer <token>` header, regardless of cookie state.

## Workaround for Testing
Use an explicitly invalid Bearer token instead of no auth to trigger 401.
