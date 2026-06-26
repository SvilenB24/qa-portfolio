# Java OOP — Notepad System

A console notepad demonstrating interfaces, inheritance, polymorphism, and a
password-protection pattern (a secured variant wrapping a simple one).

## What it demonstrates
- **Interface** — `INotepad` defines the contract (add / replace / delete / print pages).
- **Inheritance** — `SimpleNotepad implements INotepad`; `SecuredNotepad extends SimpleNotepad`.
- **Polymorphism & override** — `SecuredNotepad` overrides every operation to require a password, then delegates to `super` (a decorator-style pattern).
- **Encapsulation** — `Page` guards its own state (null-safe text handling).
- **Collections** — pages stored in a `List<Page>`.

## Classes
| Class | Role |
|-------|------|
| `INotepad` | Interface — notepad contract |
| `Page` | A single page (title + text), null-safe |
| `SimpleNotepad` | Basic notepad over a `List<Page>` |
| `SecuredNotepad` | Password-protected notepad; overrides each op + `super` |
| `Demo` | `main` — demonstrates both notepads |

> Note: `SecuredNotepad` prompts for a password on each operation (interactive console input).

## Run
```bash
javac src/*.java -d out && java -cp out Demo
```

## Author
Svilen Borisov — Junior QA Engineer · [GitHub](https://github.com/SvilenB24)
