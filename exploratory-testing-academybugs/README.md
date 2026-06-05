# Exploratory Testing — AcademyBugs Demo Shop

A **Session-Based Test Management (SBTM)** exploratory testing session: charter-driven,
time-boxed, and documented with a session sheet, severity triage, and a debrief.

## 🎯 What this demonstrates

- Writing an **exploratory charter** (`Explore … using … to discover …`)
- Running a **time-boxed recon session** (90 min)
- Using a **multi-lens heuristic** (functional / visual / content / performance / crash)
  — a tailored subset of SFDPOT
- Capturing findings in a structured **session sheet**
- Assigning **Severity** with consistent, defensible reasoning
- Closing with a professional **SBTM debrief** (coverage, risk, what's next)

## 📊 Result

**25 defects** found and categorised:

| Severity | Count |
|----------|-------|
| Critical | 1 |
| High | 9 |
| Medium | 5 |
| Low | 10 |

**Top risk:** a grand-total miscalculation that **overcharges the customer by $100**
(financial/trust impact), plus several page-freezing crashes.

Full session: **[exploratory-session.md](./exploratory-session.md)**

## 🛠️ Tools & techniques

- **Exploratory testing** (SBTM): charter → session notes → debrief
- **Heuristics:** SFDPOT-derived multi-lens model
- **Risk/triage:** Severity classification

## 👤 Author

Svilen Borisov — Junior QA Engineer · [GitHub](https://github.com/SvilenB24)
