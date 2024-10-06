# Formula Evaluation

## Overview

This Java console program reads a series of mathematical formulas from a text file, evaluates them according to the BODMAS order of operations, and outputs the results. The results are printed to the console and saved to a new text file (`result.txt`), with error handling for malformed formulas.

## Features

- **Load Formulas**: The program reads mathematical formulas from a text file (`formulas.txt`).
- **BODMAS Evaluation**: Formulas are evaluated according to the BODMAS order of operations (Bracket, OR, Division, Multiplication, Addition, and Subtraction).
- **Error Handling**: 
  - Missing equal symbols or mismatched brackets result in an error (`E`).
  - Mathematical errors, such as division by zero, are also marked as errors.
- **Output**: The results of valid formulas are printed with precision up to 2 decimal points, and all formulas with their results are saved to a new text file (`result.txt`).
  
## How to Run

1. Place the `formulas.txt` file in the project directory with each formula ending with an equal sign (`=`).
2. Compile and run the C++ program.
3. The program will output the results of each formula and save them in `result.txt`.

## Text File Format

- **Input**: The `formulas.txt` file contains mathematical formulas with integer values. Each line contains a formula that ends with an equal sign (`=`).
- **Output**: The `result.txt` file contains the formulas and their results. If there is an error, it will be marked with `E`.
