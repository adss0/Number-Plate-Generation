# Number Plate Generator 🚘

**A Java program that generates unique UK-style car number plates (like `YC19 XUE`) from a memory tag and a registration date. It works out the correct age identifier, never repeats a plate, even across runs, and is built around the Factory and Observer design patterns.**

> 🧩 Pure Java with no external libraries. A small, clean example of object-oriented design.

---

## How it works

```
 memory tag "YC" ─┐
                  ├─▶ AgeIdentifierCalculator ─▶ "19" ─┐
 date 04/07/2019 ─┘                                    ├─▶ "YC19 XUE" ─▶ unique? ─▶ save + notify
                      RandomLetterGenerator  ─▶ "XUE" ─┘                   │ no
                                                                           └─▶ try new letters
```

1. **Memory tag.** You pass in the two-letter area code, for example `YC`, `LT` or `FF`.
2. **Age identifier.** The registration date (`dd/MM/yyyy`) is turned into two digits using the UK rules:
   - **March to August:** the last two digits of the year. `04/07/2019` → **19**
   - **September to December:** the last two digits of the year + 50. `15/09/2019` → **69**
   - **January and February:** still part of the *previous* September period, so the previous year + 50. `23/01/2003` → **52**
3. **Random letters.** Three random capital letters are added, never using `I` or `Q`.
4. **Uniqueness.** The plate is checked against every plate generated before (stored in `generated_plates.txt`). If it already exists, new letters are drawn until it's unique.
5. **Notify and save.** Observers are told about the new plate (the built-in logger prints it), and the plate is added to the file.

---

## Features

| | Feature |
|---|---|
| 🇬🇧 | UK plate format: memory tag + age identifier + 3 random letters |
| 📅 | Correct age identifier for every month, including the January/February rule |
| 🔤 | Random letters that skip `I` and `Q` |
| ♻️ | Uniqueness checked across runs using a saved file |
| 🏭 | **Factory pattern:** `GenerateFactory` creates the letter generator and age calculator |
| 👀 | **Observer pattern:** `PlateObserver`s are notified of every new plate (`PlateLogger` prints it) |

---

## Tech stack

| Area | Technology |
|---|---|
| Language | Java 21 (the IntelliJ project's level; no newer language features are needed) |
| Libraries | None, only the Java standard library (`java.time`, `java.io`) |
| Storage | Plain text file (`generated_plates.txt`) |

### Project structure

```
src/com/numberplate/
  Main.java                       ← Generates three example plates
  service/
    NumberPlateService.java       ← Puts the plate together and keeps it unique
    AgeIdentifierCalculator.java  ← Date → two-digit age identifier
    RandomLetterGenerator.java    ← Three random letters (no I or Q)
    GenerateFactory.java          ← Factory for the generators
  storage/
    PlateRepository.java          ← Reads and saves generated_plates.txt
  Observer/
    Observer.java                 ← Keeps the list of observers and notifies them
    PlateObserver.java            ← Observer interface
    PlateLogger.java              ← Prints each new plate
```

---

## Getting started

**Requirements:** a JDK (21 recommended)

**In an IDE:** open the folder in IntelliJ IDEA and run `Main`.

**From a terminal:** run these from the project folder:

```bash
javac -d out $(find src -name "*.java")
```

```bash
java -cp out com.numberplate.Main
```

### Sample output

```text
New plate generated: YC19 XTM
New plate generated: LT52 DVK
New plate generated: FF32 ULW
```

The letters are random, so yours will be different. Each plate is also added to `generated_plates.txt` in the folder you run it from.

---

## Ideas for improvement

- **User input:** let the user type in the memory tag and date instead of using the examples in `Main`.
- **Validation:** check that memory tags and dates are valid before generating a plate.
- **Faster uniqueness check:** keep the saved plates in a `HashSet` for instant lookups.
- **Unit tests:** add JUnit tests for the age identifier rules and edge cases.
- **More output formats:** export plates as CSV or JSON, or store them in a database.
- **A GUI:** a simple window for generating plates.

---

## License

This project is licensed under the MIT License.
