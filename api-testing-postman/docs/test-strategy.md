# Test Strategy — DummyJSON API

## Purpose
Validate functional correctness, response format compliance, and basic security
of the DummyJSON public API.

## Scope
- Authentication flow (login + token usage)
- Product CRUD operations (read/list/create)
- Negative testing for unauthorized access

## Out of Scope
- Performance/load testing (handled separately with JMeter)
- Security penetration testing
- Server-side validation depth

## Test Approach
Manual exploratory testing in Postman → automated regression suite via Newman →
CI/CD execution on every push via GitHub Actions.

## Quality Goals (NFRs)
- All endpoints respond within 500ms under normal load
- Response format MUST be valid JSON with documented schema
- Authentication MUST be enforced on protected endpoints

## Test Levels
1. **Functional** — status codes, response structure, data correctness
2. **Schema** — required fields present in responses
3. **Security** — negative tests for missing/invalid auth
4. **Performance** — basic response time assertions (< 500ms)

## Tools
- Postman (test design)
- Newman (CLI execution)
- GitHub Actions (CI/CD)

## Entry Criteria
- API is reachable
- Test credentials are valid

## Exit Criteria
- 100% of automated tests pass
- All severity High+ defects logged and triaged
