# 🚘 Number Plate Generator

A Java-based application that generates UK-style car number plates using a memory tag and registration date. It ensures uniqueness across sessions and adheres to UK number plate format rules.

---

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

### 📁 Output File
All generated plates are appended to:
```bash
generated_plates.txt
```