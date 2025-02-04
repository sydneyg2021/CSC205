# The Personnel Database - CSC 205 Project 3

## Problem Statement  
Develop a program that allows users to **maintain wage information** for employees within a company. The program supports:  
- **Computing pay**  
- **Raising wages**  
- **Printing records**  
- **Uploading and downloading data files**  

---

## Algorithm  
The program utilizes **object-oriented programming (OOP)** principles, implementing an **abstract base class `Employee`**, which is extended by:  
- **`HourlyEmployee`** (wage based on hours worked)  
- **`SalariedEmployee`** (fixed wage regardless of hours worked)  

By leveraging **polymorphism**, these subclasses implement methods such as:  
- `toString()` → Formats employee details  
- `computePay()` → Calculates wages for each employee  

---

## Class Structure  

### `Employee` (Base Class)  
- Serves as the **abstract base class**.  
- Defines common attributes for **all employees**, including:
  - `name`
  - `wage`
- Enables **inheritance** for different employee types.  

### `HourlyEmployee` (Subclass)  
- Extends `Employee` to model **hourly workers**.  
- Calculates wages based on **hours worked**.  
- If **hours worked ≥ 40**, an **overtime bonus** is applied.  

### `SalariedEmployee` (Subclass)  
- Extends `Employee` to model **salaried workers**.  
- Employees receive a **fixed salary**, regardless of hours worked.  

### `Personnel` (Client Class)  
- Runs the **menu system** and performs key operations:
  - **Computing pay**  
  - **Raising wages**  
  - **Printing employee records**  
  - **Uploading and downloading data files**  

---

## Input & Output  

### **Input**  
- Reads the **`Employees.dat`** file.  
- Stores data into an **ArrayList of Employee objects**.  
- Prints the imported employee records.  

### **Output**  
- Takes the **ArrayList of Employee objects**.  
- Writes each employee record **back to `Employees.dat`**.  

---

## Notes  
- The **`Employees.dat`** file **must be present** in the directory before execution.  
- The program uses **file handling** to read and write employee data.  

---

## How to Run  
1. Compile the program:  
   ```sh
   javac Personnel.java

2. Run the program
   ```sh
   java Personnel
   
3. Ensure Employees.dat is available in the directory.
