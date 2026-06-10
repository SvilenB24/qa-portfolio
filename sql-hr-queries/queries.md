# SQL Queries — HR Database

Grouped by skill. Each query notes **what it checks / returns**.

---

## 1. Filtering (SELECT / WHERE / LIKE)

```sql
-- Employees with no manager (top of the hierarchy)
SELECT Name, Email FROM Employees WHERE ManagerId IS NULL;

-- Skills containing 'Java'
SELECT Id, Name FROM Skills WHERE Name LIKE '%Java%';

-- Salary below 1000 OR exactly 2000  (note: OR needs the full condition, not "OR 2000")
SELECT Name, Salary FROM Employees WHERE Salary < 1000 OR Salary = 2000;

-- Names containing 'ov' but NOT ending in it
SELECT Name FROM Employees WHERE Name LIKE '%ov%' AND Name NOT LIKE '%ov';

-- First 10 employees who joined
SELECT Name FROM Employees ORDER BY HireDate LIMIT 10;
```

## 2. Aggregations (GROUP BY / HAVING)

```sql
-- Employees per title
SELECT TitleId, COUNT(*) AS CountOfEmployees
FROM Employees GROUP BY TitleId;

-- Departments with more than 2 employees earning over 2000
-- (WHERE filters rows BEFORE grouping; HAVING filters groups AFTER)
SELECT DepartmentId, COUNT(*) AS Cnt
FROM Employees
WHERE Salary > 2000
GROUP BY DepartmentId
HAVING COUNT(*) > 2;

-- Number of distinct managers
SELECT COUNT(DISTINCT ManagerId) FROM Employees;
```

## 3. JOINs

```sql
-- INNER: each employee with their department name
SELECT e.Name, d.Name AS Department
FROM Employees e
INNER JOIN Departments d ON e.DepartmentId = d.Id;

-- Total salary per title (JOIN + aggregate)
SELECT t.Name, SUM(e.Salary) AS TotalAmountOfSalaries
FROM Titles t
JOIN Employees e ON e.TitleId = t.Id
GROUP BY t.Name;

-- 3-table join: employees and their skills, filtered to 'Java programming'
SELECT e.Name, s.Name AS Skill
FROM Employees e
JOIN Employee_Skills es ON es.EmployeeId = e.Id
JOIN Skills s ON es.SkillId = s.Id
WHERE s.Name = 'Java programming';

-- SELF JOIN: each employee with their manager's name (LEFT keeps the boss with no manager)
SELECT e.Name AS Employee, m.Name AS Manager
FROM Employees e
LEFT JOIN Employees m ON e.ManagerId = m.Id;
```

## 4. Anti-joins — data-integrity checks (LEFT JOIN + IS NULL)

```sql
-- Departments WITHOUT any employees
SELECT d.Name
FROM Departments d
LEFT JOIN Employees e ON e.DepartmentId = d.Id
WHERE e.Id IS NULL;

-- Skills that NO employee has
SELECT s.Name
FROM Skills s
LEFT JOIN Employee_Skills es ON es.SkillId = s.Id
WHERE es.SkillId IS NULL;

-- ALL employees with their certificate count (LEFT + COUNT(column) → 0 for those with none)
SELECT e.Name, COUNT(ec.CertificateId) AS NumberOfCert
FROM Employees e
LEFT JOIN Employee_Certificates ec ON ec.EmployeeId = e.Id
GROUP BY e.Name;
```

## 5. Date functions

```sql
-- Employees hired in the last 2 years 6 months (= 30 months)
SELECT COUNT(*) FROM Employees
WHERE HireDate >= DATE_SUB(CURDATE(), INTERVAL 30 MONTH);

-- Hires per year and month
SELECT YEAR(HireDate) AS y, MONTH(HireDate) AS m, COUNT(*) AS CountOfEmployees
FROM Employees
GROUP BY YEAR(HireDate), MONTH(HireDate);

-- Each employee and days worked in the company (COALESCE handles current employees)
SELECT e.Name, DATEDIFF(COALESCE(e.EndDate, CURDATE()), e.HireDate) AS NumberOfDaysInCompany
FROM Employees e;

-- The 3 months with the most vacation requests
SELECT MONTH(RequestDate) AS month, COUNT(*) AS vacations
FROM Vacations
GROUP BY MONTH(RequestDate)
ORDER BY COUNT(*) DESC
LIMIT 3;

-- Number of employees on vacation more than 10 days in 2012
SELECT COUNT(*) AS cnt
FROM Vacations
WHERE DATEDIFF(ToDate, FromDate) > 10 AND YEAR(FromDate) = 2012;
```

## 6. DML / DDL

```sql
-- DML: full safe cycle (always with WHERE)
INSERT INTO Skills (Name) VALUES ('Playwright');
UPDATE Skills SET Name = 'Playwright (E2E)' WHERE Name = 'Playwright';
DELETE FROM Skills WHERE Name LIKE 'Playwright%';

-- DDL: create, alter, drop
CREATE TABLE practice_books (
  id    INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  year  INT
);
ALTER TABLE practice_books ADD author VARCHAR(100);
DROP TABLE practice_books;
```

## 7. View

```sql
CREATE VIEW v_engineering AS
SELECT e.Name, e.Salary
FROM Employees e
JOIN Departments d ON e.DepartmentId = d.Id
WHERE d.Name = 'Software Engineering';
```
