# 🚘 Number Plate Generator

A Java-based application that generates UK-style car number plates using a memory tag and registration date. It ensures uniqueness across sessions and adheres to UK number plate format rules.

---

## Table of Contents

1. [Features](#-features)
2. [Number Plate Format](#-number-plate-format)
3. [Components](#️-components)
4. [Technologies](#-technologies)
5. [Design Patterns Used](#-design-patterns-used)
6. [How to Run](#-how-to-run)
7. [Improvements](#improvements)
8. [License](#license)



## ✨ Features

- ✅ Generates number plates in the format: `XX00 XXX`
- 📅 Calculates the correct age identifier based on registration date
- ♻️ Ensures uniqueness — checks and stores plates persistently
- 🧱 Implements Design Patterns:
  - **Factory** for generator instantiation
  - **Observer** to log and monitor plate generation
- 💾 Stores all generated plates in `generated_plates.txt`

---

## 🧠 Number Plate Format

Each number plate follows this format:

MemoryTag + AgeIdentifier + " " + RandomLetters Example: YC19 XUE
### 🧩 Components

- **Memory Tag**: 2-letter code (e.g., `YC`, `LT`, `FF`)
- **Age Identifier**:
  - March to August → last two digits of the year (e.g., `2019` → `19`)
  - September to February → last two digits + `50` (e.g., `Feb 2003` → `53`)
- **Random Letters**: 3 uppercase letters (excluding `I` and `Q`)

---

## 🔧 Technologies

- Java 17 or higher
- No external libraries — pure Java (`BufferedReader`, `FileWriter`, etc.)
- Follows clean object-oriented design

---

## 🛠️ Design Patterns Used

Factory Pattern:
The factory pattern is used to instantiate the correct number plate generator based on the requirements (e.g., date and memory tag generation).

Observer Pattern:
The observer pattern is implemented to log and track the generated number plates, providing real-time updates on plate generation.

---

## 🚀 How to Run

You can use any IDE like IntelliJ or run via terminal:

### 🧪 Compile

```bash
java -cp out com.numberplate.Main
```


### 📁 Output Sample
```text
YC19 XUE
LT53 LLP
FF32 RFW
```

### 📁 Output Sample
text
YC19 XUE
LT53 LLP
FF32 RFW

---

## 🚀 Improvements

- **Customizable Memory Tags**: Allow the user to input a list of memory tags for more control over the number plate generation.
- **GUI Interface**: Build a graphical user interface (GUI) for easier interaction with the number plate generator.
- **More Output Formats**: Add options to export generated plates in CSV, JSON, or database formats.
- **Enhanced Uniqueness Check**: Use `HashSet` for O(1) lookup time to ensure plate uniqueness, combined with persistent storage for cross-session tracking.
- **Batch Processing**: Support batch generation and submission of number plates to external systems (e.g., oil companies or vehicle registries).
- **Database Integration**: Use a relational or NoSQL database to store generated plates for better scalability and extensibility.
- **Date Range Validation**: Ensure the registration date is within valid UK date ranges to prevent invalid plate generation.
- **Unit Testing**: Implement unit tests (e.g., with JUnit) to improve reliability and catch edge cases.
- **Internationalization**: Extend the application to support number plate formats for other countries.
---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
