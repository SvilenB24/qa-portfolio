# Exploratory Testing Session — AcademyBugs Demo Shop

**Application under test:** https://academybugs.com/find-bugs/
**Approach:** Session-Based Test Management (SBTM) — charter-driven, time-boxed,
recon session using a multi-lens heuristic.

---

## Charter (Recon Session)

| | |
|---|---|
| **Explore** | the AcademyBugs demo shop page |
| **Using** | five lenses (functional, visual, content, performance, crash) + comparison against normal e-commerce conventions |
| **To discover** | and categorise as many defects as possible |
| **Time-box** | 90 min |
| **Tester** | Svilen Borisov |
| **Date** | 2026-06-01 |

---

## Session Notes

| # | Lens | Observation | Expected | Severity |
|---|------|-------------|----------|----------|
| 1 | Functional | Clicking "Update" resets product quantity back to 2 | Quantity can be increased past 2 | High |
| 2 | Functional | Grand total is $100 more than the sum of all products in the cart | Grand total equals the sum of all products | **Critical** |
| 3 | Functional | The manufacturer link opens an error page | The manufacturer link shows an appropriate page | Medium |
| 4 | Functional | Clicking "Filter by price" reloads the same page | A list of products in the selected price range is shown | Medium |
| 5 | Functional | The Twitter share button shows an error page | The Twitter share button shows an appropriate page | Medium |
| 6 | Visual | One product image has white space on the right | The product image fills the box entirely | Medium |
| 7 | Visual | The "Sign In" button caption is misaligned vertically | The caption is centered vertically | Low |
| 8 | Visual | In the store menu, item images have unnecessary space underneath | Item images have no space underneath | Low |
| 9 | Visual | The "Sign In" button overlaps the footer | The button sits above the footer | Low |
| 10 | Visual | The password field title is not aligned like the field above | The title is aligned consistently | Low |
| 11 | Content | Text under the "New User" section is in another language | The text is in English | Low |
| 12 | Content | Unreadable symbols appear in the shopping cart popup | All characters are clear to a regular user | Low |
| 13 | Content | A product's short description and description are not in English | Both are in English | Medium |
| 14 | Content | Color options misspelled: "Yelow" (Yellow), "Orang" (Orange) | Colors spelled correctly | Low |
| 15 | Content | Uneven letter spacing before the last letter of "Return to Store" | Even spacing in the button caption | Low |
| 16 | Performance | Billing Information loads infinitely after clicking "Update" | Billing information is updated | High |
| 17 | Performance | "Your Order History" section loads infinitely | Order history shows appropriate info | High |
| 18 | Performance | The Billing Address section loads infinitely | Billing address shows appropriate info | Medium |
| 19 | Performance | A product in the "Hot Item" section loads infinitely | The product is displayed | High |
| 20 | Performance | "MySpace" share page loads infinitely | The product can be shared | Low |
| 21 | Crash | The page freezes when changing the currency | The currency is changed as expected | High |
| 22 | Crash | On the "Find Bugs" results, clicking the result-count numbers freezes the page | The selected number of results is displayed | High |
| 23 | Crash | Clicking "Post Comment" makes the page unresponsive | The comment is posted under the product | High |
| 24 | Crash | "Retrieve Password" makes the page unresponsive and no email is sent | The password reset email is sent | High |
| 25 | Crash | Increasing quantity with the pink or green color chosen crashes the page | Quantity is increased to the desired value | High |

---

## Session Debrief

- **Duration:** 90 min
- **Areas covered:** product listing, cart, checkout, billing, account, sharing, comments
- **Bugs found:** 25 (Functional 5 / Visual 5 / Content 5 / Performance 5 / Crash 5)
- **Severity spread:** Critical 1 · High 9 · Medium 5 · Low 10
- **Highest risk:**
  - **#2** — Grand total is $100 higher than the sum of items: customers would be
    **overcharged**. Financial / trust / legal impact → the most serious bug.
  - **#1** — Clicking "Update" resets quantity to 2: blocks customers from updating
    their cart, hurting the core purchase flow.
  - **All 5 crash/freeze bugs** — the system must never freeze in front of a customer;
    it causes abandonment and lost sales.
- **Not covered / next session:** This is a closed exercise with exactly 25 planted
  bugs, all of which were found. (In a real product this section would list untested
  areas — other browsers, network conditions, edge cases, etc.)
