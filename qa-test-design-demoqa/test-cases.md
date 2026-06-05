# Test Cases — Mobile Number Field (DemoQA Practice Form)

**Application under test:** https://demoqa.com/automation-practice-form
**Field under test:** Mobile Number
**Business rule:** Exactly 10 digits, numeric only, mandatory.
**Techniques applied:** Equivalence Partitioning (EP) + Boundary Value Analysis (BVA)

**Common preconditions for every test case:**
All other mandatory fields (First Name, Last Name, Gender) are filled with valid
data, so that the only variable under test is the Mobile Number field.

---

## TC-01 — Accepts exactly 10 digits (positive)

| | |
|---|---|
| **Technique** | EP (valid class) + BVA (boundary = 10) |
| **Test data** | `1234567890` |

**Steps**
1. Enter First Name = "Ivan"
2. Enter Last Name = "Ivanov"
3. Choose Gender = "Male"
4. Click the Mobile Number field
5. Enter `1234567890`
6. Click Submit

**Expected:** Form submits successfully; a "Thanks for submitting the form" modal
appears showing the entered Mobile (1234567890).
**Actual:** Modal appeared with the submitted data.
**Status:** ✅ PASS

---

## TC-02 — 9 digits (negative, BVA lower)

| | |
|---|---|
| **Technique** | BVA (boundary − 1) |
| **Test data** | `123456789` |

**Steps:** Steps 1–4 as above → Enter `123456789` → Click Submit
**Expected:** Form is not submitted; Mobile field flagged as invalid; no modal.
**Actual:** Form not submitted; field highlighted; no modal.
**Status:** ✅ PASS

---

## TC-03 — 11 digits (negative, BVA upper)

| | |
|---|---|
| **Technique** | BVA (boundary + 1) |
| **Test data** | `12345678901` |

**Steps:** Steps 1–4 as above → Attempt to enter 11 digits → Observe field content
**Expected:** Field does not accept more than 10 characters; the 11th digit is
blocked; field retains only the first 10 digits (`maxlength=10` enforced).
**Actual:** Field stopped at 10 characters; 11th digit ignored.
**Status:** ✅ PASS
**Note:** Suggestion — show a tooltip "Maximum 10 digits" so the user understands
why further input is blocked.

---

## TC-04 — 10 letters (negative)

| | |
|---|---|
| **Technique** | EP (invalid class: non-numeric) |
| **Test data** | `abcdefgqwe` |

**Steps:** Steps 1–4 as above → Enter `abcdefgqwe` → Click Submit
**Expected:** Form does not submit; non-numeric input rejected.
**Actual:** Form does not submit; no modal.
**Status:** ✅ PASS

---

## TC-05 — 10 symbols (negative)

| | |
|---|---|
| **Technique** | EP (invalid class: non-numeric) |
| **Test data** | `!@#$%^&*()` |

**Steps:** Steps 1–4 as above → Enter `!@#$%^&*()` → Click Submit
**Expected:** Form does not submit; symbols rejected.
**Actual:** Form does not submit; no modal.
**Status:** ✅ PASS

---

## TC-06 — 10 letters and numbers (negative)

| | |
|---|---|
| **Technique** | EP (invalid class: mixed) |
| **Test data** | `12345abcde` |

**Steps:** Steps 1–4 as above → Enter `12345abcde` → Click Submit
**Expected:** Form does not submit; mixed alphanumeric rejected.
**Actual:** Form does not submit; no modal.
**Status:** ✅ PASS

---

## TC-07 — 10 numbers and symbols (negative)

| | |
|---|---|
| **Technique** | EP (invalid class: mixed) |
| **Test data** | `12345!@#$%` |

**Steps:** Steps 1–4 as above → Enter `12345!@#$%` → Click Submit
**Expected:** Form does not submit; digits + symbols rejected.
**Actual:** Form does not submit; no modal.
**Status:** ✅ PASS

---

## TC-08 — 9 digits + space (negative)

| | |
|---|---|
| **Technique** | EP (invalid class: contains whitespace) |
| **Test data** | `12345 6789` (9 digits + 1 space = 10 characters) |

**Steps:** Steps 1–4 as above → Enter `12345 6789` → Click Submit
**Expected:** Form does not submit; whitespace makes it only 9 digits → rejected.
**Actual:** Form does not submit; no modal.
**Status:** ✅ PASS

---

## TC-09 — Empty field (negative)

| | |
|---|---|
| **Technique** | EP (invalid class: empty) + required-field check |
| **Test data** | (empty) |

**Steps:** Steps 1–3 as above → Leave Mobile Number empty → Click Submit
**Expected:** Form does not submit; mandatory field prevents submission.
**Actual:** Form does not submit; no modal.
**Status:** ✅ PASS

---

## Summary

| Technique | Test cases | Result |
|-----------|-----------|--------|
| EP — valid class | TC-01 | PASS |
| EP — invalid classes | TC-04, 05, 06, 07, 08, 09 | PASS |
| BVA — boundary (9 / 10 / 11) | TC-02, TC-01, TC-03 | PASS |

**9 test cases designed, executed and documented. 9/9 PASS — no defects found.**
