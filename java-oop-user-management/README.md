# Java OOP — User Management System

A console user-management system demonstrating interfaces, abstract classes,
inheritance, polymorphism, and composition.

## What it demonstrates
- **Interfaces** — `User` (login/logout); `AdminUser extends User` (an interface inheriting an interface) adds create/delete/list.
- **Abstract class** — `AbstractUser` holds shared state (`final` username, registration date, login flag) + validation.
- **Inheritance** — `UserImpl` and `AdminUserImpl` extend `AbstractUser`.
- **Polymorphism** — `instanceof` + casting to distinguish admins from regular users at runtime.
- **Composition** — `AdminUserImpl` owns a `DataBase` (HAS-A) for storage.
- **Robustness** — handles duplicate usernames, missing users, full and empty database.

## Classes
| Class | Role |
|-------|------|
| `User` | Interface — base user contract (login, logout, ...) |
| `AdminUser` | Interface extending `User` — admin actions (create / delete / list) |
| `AbstractUser` | Abstract base — shared state + validation |
| `UserImpl` | Regular user |
| `AdminUserImpl` | Admin — manages users via a `DataBase` |
| `DataBase` | User storage |
| `Demo` | `main` — creates/deletes users, demonstrates polymorphism and edge cases |

## Run
```bash
javac src/*.java -d out && java -cp out Demo
```

## Author
Svilen Borisov — Junior QA Engineer · [GitHub](https://github.com/SvilenB24)
