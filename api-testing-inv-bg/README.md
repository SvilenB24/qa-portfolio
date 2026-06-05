# API Testing — inv.bg (Risk-Based)

Risk-based API testing of the **inv.bg** invoicing API using **Postman**.

## 🎯 Approach
Endpoints are prioritised by **risk** — not tested equally. Highest-risk first:
- **Authentication / authorization** (can a token access data it shouldn't?)
- **Invoice creation** (wrong amounts = money/legal impact)
- **Financial calculations** (VAT, totals, rounding)
- **Delete / edit** (data loss, integrity)

Each request is checked on the **3 API axes**: status code, response format, response data.

## 🔐 Security
The API token is **not stored in this repo**. It lives in
`qa-learning/_system/secrets.local.md` (gitignored) and is used in Postman as a
**secret environment variable** `{{inv_token}}`. Postman environment exports are
gitignored (they would contain the token).

## 📂 Contents
- `inv-bg.postman_collection.json` — collection referencing `{{base_url}}` + `{{inv_token}}`
- `docs/` — risk analysis, test notes, findings

## 👤 Author
Svilen Borisov — Junior QA Engineer
