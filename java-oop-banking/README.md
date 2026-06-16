# Java OOP — Banking System

A console banking model demonstrating core Object-Oriented Programming in Java:
encapsulation, inheritance, polymorphism, and exception handling.

## What it demonstrates
- **Encapsulation** — `private`/`protected` fields, mutated only through validated methods.
- **Inheritance** — `SavingsAccount` and `CheckingAccount` extend `Account`, reusing shared logic via `super(...)`.
- **Polymorphism** — each type overrides `toString()`; `CheckingAccount` overrides `withdraw()`. One `List<Account>` loop yields type-specific behavior.
- **Exceptions** — invalid input fails fast with `IllegalArgumentException`; `withdraw`/`transfer` return `boolean` for success vs. failure.
- **Static state** — `totalAccounts` shared across all instances.

## Classes
| Class | Role |
|-------|------|
| `Account` | Base: holder, number, balance, currency; `deposit`, `withdraw`, `transfer` |
| `SavingsAccount` | Adds interest rate + `applyInterest()` / `calculateInterest()` |
| `CheckingAccount` | Adds overdraft; overrides `withdraw()` to allow negative balance |
| `AccountDemo` | `main` — mixed accounts, polymorphism, transfers |

## Run
```bash
javac src/*.java -d out && java -cp out AccountDemo
```

## Author
Svilen Borisov — Junior QA Engineer · [GitHub](https://github.com/SvilenB24)
