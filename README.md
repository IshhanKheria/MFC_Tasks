# 📚 Library Management System & 🔢 Sorting Complexity

## 📌 About This Repository

This repository contains two Java programs:

* **Library Management System** – A simple console-based library management system.
* **Sorting Complexity** – A Java program that implements and compares sorting algorithms.

## 📚 Library Management System

### 📝 Features:

* Add, Remove, Update, and List Books & Members.
* Auto-Sorting: Books and members are sorted automatically in ascending order of ID.
* Error Handling: Prevents crashes due to invalid inputs.
* User-Friendly Interface with a simple text-based menu.

### 🚀 How It Works:

* The user selects an operation from the menu.
* For listing entries, a serial number is displayed.
* Bubble Sort is used to maintain sorted lists.

### 🏗 Technologies Used:

* Java (ArrayList, Scanner, Exception Handling)
* Bubble Sort.

1.  **Compile the program:**

    ```bash
    javac LibraryManagement.java
    ```

2.  **Run the program:**

    ```bash
    java LibraryManagement
    ```

## 🔢 Sorting Complexity Analysis

This Java program implements and compares the performance of several common sorting algorithms.

### 📝 Features:

* **Algorithm Implementations:** Includes Bubble Sort, Selection Sort, and Insertion Sort.
* **Time Complexity Analysis:** Measures the execution time of each sorting algorithm to demonstrate their performance characteristics.
* **Random Data Generation:** Generates arrays of random integers to test the algorithms with diverse input.
* **Performance Comparison:** Displays the execution time for each algorithm, allowing for a direct comparison of their efficiency.

### 🚀 How It Works:

1.  **Random Array Generation:** The program generates an array of random integers with a configurable size.
2.  **Algorithm Execution:** Each sorting algorithm (Bubble Sort, Selection Sort, Insertion Sort) is applied to a copy of the generated array.
3.  **Time Measurement:** The execution time for each algorithm is measured using `System.currentTimeMillis()`.
4.  **Result Display:** The program displays the execution time for each algorithm, providing a comparison of their performance.

### 🏗 Technologies Used:

* **Java:** The program is written in Java.
* **Basic Sorting Algorithms:** Implementation of fundamental sorting algorithms.
* **Time Measurement:** Utilizes `System.currentTimeMillis()` for performance analysis.

### 📌 How to Run:

1.  **Compile the program:**

    ```bash
    javac SortingComplexity.java
    ```

2.  **Run the program:**

    ```bash
    java SortingComplexity
    ```
