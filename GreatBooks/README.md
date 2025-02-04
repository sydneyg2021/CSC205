# The Great Books Program - CSC 205 Project 2

## Problem Statement
Develop a Library catalog that includes:  
- A **display record** option.  
- A **search for record** option.  

The program processes a given database of book records.

---

## Sorting Algorithm: Selection Sort
The program sorts book records alphabetically using **Selection Sort**.  
Selection Sort repeatedly finds the **minimum element** from the unsorted part and places it at the beginning.

**Example:**  

    Initial:  [64, 25, 12, 22, 11]
    Pass 1:   [11, 25, 12, 22, 64]
    Pass 2:   [11, 12, 25, 22, 64]
    Pass 3:   [11, 12, 22, 25, 64] 

## Searching Algorithm: Binary Search
- Binary Search operates on a sorted array (ascending or descending).
It repeatedly divides the search space in half until the element is found.

Example: Searching for 25 in [11, 12, 22, 25, 64]

      F: 0, L: 4 , M: 2  
      Pass 1: Is 25 < 22 or > 22? → 25 > 22  
              Update: F = 2, L = 4, M = 3  
      Pass 2: Is 25 < 25 or > 25? → 25 == 25 → Element found!

## Methods
`startup()`
- Prints a prompt asking for the filename.
- Checks if the file exists in the directory.
- Calls input() to fill the ArrayList.
    - User input is NOT case-sensitive.
 
`input()`
- Reads the filename and processes it line by line.
- Splits each line using ";" as a delimiter.
- Stores book details into a book record.
- Continues until all books are stored.

`sort()`
- Sorts book records alphabetically using Selection Sort.

`menu()`
- Displays a menu with three options:
    -  Calls display() to print all book records.
    -  Calls search() to find a book by title.
    -  Exits the program with a goodbye statement.

`display()`
- Iterates through book records and prints them.

`search()`
- Uses Binary Search to find the user-inputted book title.
- Case does NOT matter (input is converted to lowercase).

## Required Files
Before running, ensure the following files are present in the directory:

- Input file (e.g., books.dat)
- LibraryBook class (required for GreatBooks to function)

## Sample Input & Output
### Initial Prompt

                        THE BOOK SEARCH PROGRAM         
    ----------------------------------------------------
    What file is your book data stored in?
    Here are the files in the current directory:
    [play.dat]
    What file is your book data stored in?
    Filename:

Sample Input: play.dat

Sample Output:

    A total of 1 books have been inputted and sorted by title.
    Please Hit Return to Continue...

### Main Menu

                   THE GREAT BOOKS SEARCH PROGRAM
    ----------------------------------------------------
    1) Display all book records
    2) Search for a book by Title
    3) Exit Search Program
    ----------------------------------------------------
    Please enter your choice >
    
### Displaying Book Records
Sample Input: 1

Sample Output:

    Record 1  
    --------------------------  
    Title:          The Iliad  
    Author's Name:  Homer  
    Copyright:      1892  
    Price:          5.60  
    Genre:          p  
    ----------------------------  
    Please Hit Return to Continue or M for Menu...
    
### Searching for a Book
Sample Input: 2

Sample Output:

    Search Title > The Iliad  
    
    Record 1  
    --------------------------  
    Title:          The Iliad  
    Author's Name:  Homer  
    Copyright:      1892  
    Price:          5.60  
    Genre:          p  
    ----------------------------  
    
    Please Hit Return to Continue...
    
### Exiting the Program
Sample Input: 3

Sample Output:

    Have a nice day!  
    Goodbye. :-)
  
## Notes:
- Input files (.dat files) must be in the directory before running.
- The LibraryBook class must also be in the directory for GreatBooks to execute properly.
