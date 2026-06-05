# API Testing Portfolio — Postman + Newman

[![Newman API Tests](https://github.com/SvilenB24/api-testing-postman/actions/workflows/newman.yml/badge.svg)](https://github.com/SvilenB24/api-testing-postman/actions/workflows/newman.yml)

QA automation project demonstrating REST API testing with Postman collections and Newman CLI runner.

## What's Inside

- **Postman Collection** with 6 requests covering CRUD, authentication, and negative testing
- **Test Assertions** in JavaScript (status codes, response format, data validation, performance)
- **Environment** with variables for base URL, credentials, and auth tokens
- **Newman CLI** for automated execution outside the Postman GUI
- **CI/CD** via GitHub Actions (runs the collection on every push)

## API Under Test

[DummyJSON](https://dummyjson.com) — public REST API for learning and prototyping.

## Test Coverage

| Request | Method | What It Tests |
|---|---|---|
| Login | POST | Authentication, token retrieval, auto-save to env |
| Get My Profile | GET | Authenticated request with Bearer token |
| Get All Products | GET | List endpoint, response schema |
| Get Product 1 | GET | Single resource retrieval |
| Add Product | POST | Resource creation, status 201 |
| Get My Profile - Invalid Token | GET | Negative test, expected 401 |

## How to Run

### Prerequisites
- Node.js v18+
- Newman: `npm install -g newman`

### Run locally
\`\`\`bash
newman run collections/dummyjson.postman_collection.json \\
  -e environments/dummyjson-dev.postman_environment.json
\`\`\`

## Tech Stack

- Postman (collection design + assertions)
- Newman (CLI test runner)
- GitHub Actions (CI/CD)

## Author

Svilen — QA Automation Engineer in training