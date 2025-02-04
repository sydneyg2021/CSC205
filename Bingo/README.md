# Bingo Game - CSC 205 Project 1

## Problem Statement
Develop a Java program that simulates a Bingo game using a 5x5 matrix. The program should:

- Randomly select a number from each column.
- Replace the selected number with an 'X'.
- Continue selecting and marking numbers until a winning Bingo card is achieved.
- Declare a win when a complete row, column, or diagonal contains all 'X's.
- Print the winning Bingo card.

## Sample Input
The program reads 25 integers from a file (`bingo.in`), representing the numbers on the Bingo card in row-major order.

## Sample Output
                B  I  N  G  O
                X  X  X  X  X
                3 26 45 53 75
                5 17 33 59 67
                7 19 42 55 74
                2 23 37 46 70

## Algorithm
1. Declare a 5x5 matrix.
2. Initialize the matrix using numbers read from `bingo.in`.
3. Print the unmarked Bingo card.
4. Start the game loop:
   - Pick a random number from each column.
   - Check if the number is a duplicate.
   - Replace the number with an 'X'.
   - Check if the card meets the win condition.
   - If a winning condition is met, stop the game; otherwise, repeat.
5. Print the final marked Bingo card and declare the win.

## Methods
- `initialize()`: Reads input and fills the Bingo card.
- `printCard()`: Displays the Bingo card.
- `playGame()`: Simulates the game loop until a win condition is met.
- `generate()`: Picks random numbers and marks them on the card.
- `checkWin()`: Determines if the card has a complete row, column, or diagonal.
- `printBin()`: Prints the list of randomly selected numbers.

## Implementation
The program:

- Supports multiple players.
- Uses a 2D array to represent the Bingo card.
- Uses an `ArrayList` to store selected numbers.
- Handles file input using `Scanner`.
- Implements win detection for horizontal, vertical, and diagonal Bingo conditions.

## How to Run
1. Compile the program using:
   ```sh
   javac Bingo.java
2. Run the program:
   ```sh
    java Bingo
3. Ensure that bingo.in exists in the same directory, containing 25 integers.
