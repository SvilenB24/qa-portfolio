# Java OOP — Library System

A console library model demonstrating advanced OOP in Java: abstract classes,
interfaces, polymorphism, collections, and exception handling.

## What it demonstrates
- **Abstraction** — `LibraryItem` is `abstract` (cannot be instantiated); `getLoanPeriodDays()` is an abstract method each type must implement.
- **Interface** — `Borrowable` is a contract (`borrow`, `returnItem`, `isAvailable`) implemented by `LibraryItem`.
- **Inheritance & polymorphism** — `Book` and `DVD` override `toString()` and `getLoanPeriodDays()`; one `listAll()` loop prints type-specific output.
- **Collections** — `Library` manages a `List<LibraryItem>` (add, count, search by title).
- **Exceptions** — borrowing a missing title throws `IllegalArgumentException`, caught so the program survives.

## Classes
| Class | Role |
|-------|------|
| `LibraryItem` | Abstract base; `borrow`, `returnItem`; implements `Borrowable` |
| `Borrowable` | Interface — the "can be borrowed" contract |
| `Book` | Adds author; loan period 30 days |
| `DVD` | Adds duration; loan period 7 days |
| `Library` | Manages the collection; `addItem`, `listAll`, `borrowItem`, `countItems` |
| `LibraryDemo` | `main` — adds, lists, borrows, handles errors |

## Run
```bash
javac src/*.java -d out && java -cp out LibraryDemo
```

## Author
Svilen Borisov — Junior QA Engineer · [GitHub](https://github.com/SvilenB24)
