# inv.bg API — Test Findings

Risk-based API testing of the inv.bg v3 API (`https://api.inv.bg/v3`) with Postman.
Tested against an empty test account, prioritising the highest-risk areas first
(authentication, then the Clients resource CRUD).

## Test suite (automated)

A self-contained Postman collection — **9 requests, 16 assertions, all passing**:

| # | Request | Checks |
|---|---------|--------|
| 1 | GET /firm — valid token (smoke) | 200, JSON, firm id 122616 |
| 2 | GET /firm — no auth | 401 |
| 3 | GET /firm — invalid token | 401 |
| 4 | GET /clients — list | 200, pagination + array structure |
| 5 | POST /clients — create | 201, captures `client_id` |
| 6 | GET /clients/{id} — verify created | 200, data matches sent |
| 7 | DELETE /clients/{id} | 204 |
| 8 | GET /clients/{id} — verify deleted | 404 |
| 9 | POST /clients — missing field | 400, error names the field |

**Design notes:**
- Each `Status / Format / Data` check applied (the 3 API checks).
- The CRUD flow is **self-cleaning**: it creates a client, verifies, deletes it, and
  confirms deletion — leaving the account as it was found.
- The `bulstat` is **randomised per run** (pre-request script) to avoid the
  soft-delete dedup behaviour (see BUG-01) — i.e. a real bug shaped the test design.

---

## BUG-01 — Re-creating a soft-deleted client returns 201 but the client is not accessible

**Title:** [BUG-01] - Clients - POST /clients - Re-creating a soft-deleted client -
Returns 201 Created but the client is not accessible

**Precondition:** Valid API token. No client with bulstat "123456789" exists.

**Steps to Reproduce:**
1. POST /clients {name, bulstat:"123456789", mol, is_reg_vat:false} → 201, id N
2. GET /clients/N → 200 (client exists)
3. DELETE /clients/N → 204 (soft delete)
4. GET /clients/N → 404 (hidden, confirms deleted)
5. POST /clients with the SAME body (same bulstat) → 201 Created + id N
6. GET /clients/N → 404 Not Found

**Actual Result:** Step 5 returns 201 Created + id, but the client is NOT accessible
(GET /clients/N → 404; not in the GET /clients list).

**Expected Result:** A 201 Created must mean the resource exists and is retrievable.
Step 5 should either actually restore/create the client (GET → 200), OR return an error
(e.g. 409 Conflict "client exists but is deleted"). It must NOT report 201 for a
resource that does not become accessible.

**Severity:** Medium — No crash or data loss (the record is recoverable via the
/restore endpoint), but the API violates REST semantics: it reports 201 Created for a
resource that is not actually accessible, which can mislead client applications into
assuming a client exists when it does not.

**Priority:** Low — Occurs only when re-adding a client whose bulstat matches a
previously soft-deleted client — an uncommon edge case.

**Root cause (confirmed):** Reproduced with three different bulstat values — the API
matches POST requests by `bulstat` and returns the soft-deleted record's id without
restoring it. The defect is independent of the specific value or id.

**Note:** A status-only assertion (201) passes here — the bug is only caught by a
**read-after-create (data) assertion**. Concrete proof that all 3 API checks matter.

---

## Minor observations / notes

1. **Validation reports one missing field at a time** — POST /clients returns only the
   first missing required key per request, not all at once → multiple round-trips.
2. **`bulstat` is not validated** — `"123456789"` (not a valid Bulgarian EIK) is
   accepted and stored; no checksum/format check.
3. **POST create returns only `{ "id": N }`** — not the full created object, so a
   follow-up GET is needed to verify the stored data.
4. **Soft delete** — records carry a `deleted` flag and have a `/clients/{id}/restore`
   endpoint; deleted records return 404 on GET by id and disappear from the list.
5. **Default value inconsistency** — some optional fields default to `""`
   (town, address) while others default to `null` (vat_number, egn, country).

## Discovered contract

`POST /clients` required fields: **`name`, `bulstat`, `mol`, `is_reg_vat`**
(discovered iteratively via the API's validation errors, as the Swagger schema was
underspecified).
