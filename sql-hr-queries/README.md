# SQL for QA — Data Validation & Analysis (HR database)

A curated set of SQL queries written against a realistic **HR management schema**
(employees, departments, titles, vacations, skills, certificates, interviews — with
foreign keys and self-references). Focused on the queries a QA engineer actually uses:
**data validation, referential-integrity checks, and reporting**.

## 🎯 Skills demonstrated
- **SELECT / WHERE / LIKE / ORDER BY / LIMIT** — filtering and ordering
- **Aggregations** — `GROUP BY`, `HAVING`, `COUNT/SUM/AVG/MIN/MAX`
- **JOINs** — INNER, **LEFT**, **anti-join** (find missing/orphaned data), **self-join**, multi-table
- **Date functions** — `DATEDIFF`, `YEAR/MONTH`, `DATE_SUB`, `CURDATE`, `COALESCE`
- **DML / DDL** — `INSERT/UPDATE/DELETE` (with mandatory `WHERE`), `CREATE/ALTER/DROP`
- **Objects** — Views

## 🔗 Why this matters for QA
- **Anti-joins** (`LEFT JOIN ... WHERE ... IS NULL`) find **orphaned / missing data** —
  a core data-integrity check (e.g. departments with no employees, skills no one has).
- **`COUNT(*)` vs `COUNT(column)`** matters after a LEFT JOIN (counting the NULL-padded row).
- **`UPDATE`/`DELETE` without `WHERE`** is the classic catastrophic bug — every query here
  treats `WHERE` as mandatory.
- Verifying a result (a "0 rows" or "many rows" result can still be **wrong**) — never trust,
  always verify against the data.

## 📂 Contents
- [**queries.md**](./queries.md) — the queries, grouped by skill, each with what it checks.

## 🗄️ Schema (key tables)
`Employees(Id, Name, TitleId→Titles, DepartmentId→Departments, Salary, HireDate, EndDate,
ManagerId→Employees, ReferrerId→Employees)` · `Departments(Id, Name, ParentId→Departments)` ·
`Titles(Id, Name, ParentId)` · `Vacations(Id, EmployeeId, Status, FromDate, ToDate)` ·
`Skills` / `Employee_Skills` (junction) · `Certificates` / `Employee_Certificates`.

## 👤 Author
Svilen Borisov — Junior QA Engineer · [GitHub](https://github.com/SvilenB24)
