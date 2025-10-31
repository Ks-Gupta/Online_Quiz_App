
---

# 🧠 Java Quiz App

A simple console-based **Quiz Application** built using **Java**, which loads questions from a CSV file (`questions.csv`).
The app randomizes both **question order** and **option order**, checks answers, and displays the final **score and performance feedback**.

---

## 🚀 Features

✅ Loads questions dynamically from a CSV file
✅ Randomizes both questions and answer options using `Collections.shuffle()`
✅ Validates user input (prevents invalid answers)
✅ Displays correct answers for wrong responses
✅ Shows total score and percentage at the end
✅ Simple and beginner-friendly code structure

---

## 🏗️ Project Structure

```
📁 Online_Quiz_App/
│
├── QuizApp.java          # Main Java file (quiz logic)
├── questions.csv         # File containing all quiz questions and answers
└── README.md             # Project documentation
```

---

## 📄 CSV File Format

The `questions.csv` file should follow this structure:

```
Question|Option1|Option2|Option3|Option4|CorrectOptionNumber
```

* Use **`|`** (pipe symbol) as a separator.
* The **CorrectOptionNumber** should be a number between `1–4` representing the correct option.

### 🧩 Example:

```
Question|Option1|Option2|Option3|Option4|CorrectOptionNumber
What is the size of int in Java?|2 bytes|4 bytes|8 bytes|16 bytes|2
Which keyword is used to inherit a class in Java?|super|this|extends|implements|3
Which of the following is not a Java feature?|Object-oriented|Use of pointers|Portable|Robust|2
```

---

## 🧰 Technologies Used

* **Java SE 8+**
* **Collections Framework** (for randomization)
* **File I/O (BufferedReader)**
* **OOP concepts** (Encapsulation, Classes, Lists)

---

## 🧑‍💻 How to Run

1. Save `QuizApp.java` and `questions.csv` in the same folder.
2. Open a terminal and navigate to that folder:

   ```bash
   cd path/to/Online_Quiz_App
   ```
3. Compile the Java file:

   ```bash
   javac QuizApp.java
   ```
4. Run the program:

   ```bash
   java QuizApp
   ```

---

## 📊 Output Example

```
=== 🧠 Welcome to the Java Quiz App! ===

Q1: What is the size of int in Java?
1) 16 bytes
2) 4 bytes
3) 2 bytes
4) 8 bytes
Enter your answer (1-4): 2
✅ Correct!

Q2: Which keyword is used to inherit a class in Java?
1) implements
2) this
3) extends
4) super
Enter your answer (1-4): 3
✅ Correct!

🎯 Quiz Finished!
Your Score: 2 / 2
Percentage: 100.00%
🏆 Excellent!
```

---

## 🧩 Concepts Demonstrated

* File Reading using `BufferedReader`
* String Splitting using `split("|")`
* List Manipulation (`ArrayList`, `Collections.shuffle()`)
* Exception Handling (`try-catch`)
* Input validation with `Scanner`

---

## 🧑‍🏫 Author

**Khushi Gupta**

---