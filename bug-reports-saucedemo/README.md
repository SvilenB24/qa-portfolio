# Bug Reports — SauceDemo (Swag Labs)

Exploratory testing of the [SauceDemo](https://www.saucedemo.com) e-commerce demo,
with **7 professionally documented bug reports** — including reproduction steps,
**justified Severity & Priority**, and triage decisions.

## 🎯 Approach

1. **Baseline first** — explored the app as `standard_user` to learn the *expected*
   behaviour (you can't recognise a bug without knowing what "correct" looks like).
2. **Hunt** — explored as `problem_user` and compared against the baseline.
3. **Triage** — separated real defects from intended behaviour, and consolidated related
   issues into single reports (one root cause = one bug).

## 🐛 Findings summary

| ID | Area | Summary | Severity | Priority |
|----|------|---------|----------|----------|
| BUG-01 | Checkout | Order completes with an empty cart ($0 order) | Medium | High |
| BUG-02 | Checkout | Last Name field redirects input to First Name → checkout blocked | High | High |
| BUG-03 | Inventory | All products show the same placeholder image | Low | High |
| BUG-04 | Inventory | "Add to cart" does nothing for 3 products | High | High |
| BUG-05 | Inventory | Sort dropdown has no effect | Medium | Medium |
| BUG-06 | Cart | "Remove" on the inventory page does not work (workaround on Cart page) | Medium | High |
| BUG-07 | Session | Cart contents leak between different user accounts | High | High |

Full details: **[bug-reports.md](./bug-reports.md)**

## 🧠 Triage notes (issues investigated and ruled OUT as defects)

Not every difference is a bug — the following were verified as **intended behaviour**:

- *Single quantity per item* — the demo has no quantity selector (missing feature, not a defect).
- *"carry.allTheThings()" in descriptions* — intentional flavour text by Sauce Labs.
- *"Swag Labs" vs "Sauce Labs"* — the store is named **Swag Labs**; **Sauce Labs** is the product brand.

## 💡 Severity vs Priority

These reports treat **Severity** (technical impact — QA owns it) and **Priority**
(business urgency — PM owns it) as **independent axes**, each justified separately.
Good examples in this set:

- **BUG-03** — *Low* severity (purely visual) but *High* priority (customers can't see
  products before buying).
- **BUG-07** — *High* severity because it is a **data-integrity / privacy** issue, not a
  cosmetic one.

## 📸 Evidence

Each bug was logged as a separate issue in **Jira** (issues QPD-10 – QPD-16) and exported
as a PDF. The exports are in [`/jira-exports`](./jira-exports) and serve two purposes:
they show the defects were tracked in a real tool, and each PDF includes the screenshot
evidence attached to that ticket.

## 🛠️ Tools

- **Exploratory testing** — baseline vs. comparison
- **Jira** — defect tracking
- **SauceDemo** — application under test

## 👤 Author

Svilen Borisov — Junior QA Engineer · [GitHub](https://github.com/SvilenB24)
