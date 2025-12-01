# Introduction to Arrays

Up until now, every program we have written has stored data using **individual variables**:

```java
int mark1;
int mark2;
int mark3;
```

This works for small tasks, but quickly becomes unmanageable. Imagine storing *30 student marks*, or *100 temperatures*, or *5000 pixel values*.  

A program with hundreds of separate variables is not realistic to write, fix, or maintain.

To solve this, Java gives us **arrays**.

An array lets us store a list of items of the *same data type*, all under *one variable name*, accessed by a number called an **index**.

Consider an array called `grades` that stores **5 independent marks**:

```
Index:     0    1    2    3    4
grades:   75   81   67   85   91
```

- `grades[0]` is 75  
- `grades[1]` is 81  
- `grades[2]` is 67  
- `grades[3]` is 85  
- `grades[4]` is 91  

This indexing system is the foundation of how arrays work:  
**index 0** is always the first element, **index 1** the second, and so on.

Arrays allow our programs to scale from tiny examples to real-world workloads.

## Why Arrays?

Consider a program meant to manage marks for a class of 30 students. It must:

- store 30 marks,
- compute the average,
- print any mark upon request.

Before arrays, you would need **30 separate variables**.  

With arrays, you can use just **one variable** holding **30 elements**.

This is the first example of a true **data structure** — a way of organizing data so programs can process it efficiently.

## What Is an Array?

An array is:

- a **list of values**,  
- all values must have the **same data type**,  
- each value is stored in an **element**,  
- each element is accessed using an **index**,  
- indices start at **0**.

Examples:

- `int[] absences` — list of student absences  
- `double[] temperatures` — list of temperatures  
- `String[] names` — list of names  

Visualization:

```
                   names
 +---------+---------+---------+---------+
 |  "Amy"  | "Chris" | "Holly" |  "Ben"  |
 +---------+---------+---------+---------+
    index 0   index 1   index 2   index 3
```

Accessing:

```java
System.out.println(names[2]);  // Holly
```

<br>

## Declaring and Creating Arrays

Recall the practice of declaring and assigning a variable in one command:

```java
int mark1 = 90;
```

This line does **two things**:

1. **declares** the variable (`int mark1;`)
2. **initializes** it with a value (`mark1 = 90;`)

Arrays follow this same two-step pattern.

### Declaring an Array

Declaring an array only introduces the *variable name* and the *type of items* it will store:

```java
int[] marks;
String[] names;
double[] menuPrices;
```

Notes:

- The **base type** (`int`, `String`, etc.) tells Java what each element will contain.
- The `[]` means the variable will store a **list** of values.
- Declaring an array **does not create the list yet**.  
  At this stage, the variable exists but it points to **nothing**.

This is similar to:

```java
int mark1;   // declared but uninitialized
```

If you try to use `marks[0]` now, the program will crash because the array has not been created.

### Creating an Array

To actually make the list in memory, you use `new`:

```java
marks = new int[30];
```

This creates an array with **30 integer elements**, all automatically set to default values.

This is similar to:

```java
mark1 = 90;   // assigns a value
```

The recommended practice is to combine the **declaring** and **creating** on one line:

```java
int[] marks = new int[30];
String[] students = new String[5];
```

This style is clearer because it prevents errors that occur when the array is declared but never created.

The default value for each element depends on the array's type:

- `0` for numeric arrays  
- `false` for boolean arrays  
- `null` for String/other object arrays

Examples:

```java
int[] scores = new int[4];
// [0, 0, 0, 0]

boolean[] hasPassport = new boolean[4];
// [false, false, false, false]
```

## Setting Element Values
Once an array has been declared, setting values can be done in a similar fashion as assigning variables.

Don't forget that arrays begin with a zero index for the first element.

```java
marks[0] = 75;
marks[1] = 81;
marks[2] = 67;
```

General pattern:

```
arrayName[index] = value;
```

## Initializing an Array (Array Initializer)

Sometimes you already know **exactly** what values the array should contain.  

In these cases, Java provides a shortcut called an **array initializer**.

Consider:

```java
int[] absences = {4, 3, 6, 8, 9};
```

This **one** line performs **three steps at once**:

1. **Declares** the array variable  
   ```java
   int[] absences;
   ```

2. **Creates** the array with the correct size  
   (Java counts 5 values → size becomes 5)  
   ```java
   absences = new int[5];
   ```

3. **Assigns** each element its value  
   ```java
   absences[0] = 4;
   absences[1] = 3;
   absences[2] = 6;
   absences[3] = 8;
   absences[4] = 9;
   ```

Putting all three steps together:

```java
int[] absences = {4, 3, 6, 8, 9};
```

### A Clearer Comparison

Without an initializer:

```java
int[] scores = new int[4];

scores[0] = 99;
scores[1] = 95;
scores[2] = 95;
scores[3] = 90;
```

With an initializer (all three steps combined):

```java
int[] scores = {99, 95, 95, 90};
```

### Another Example

```java
int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

System.out.println(daysInMonth[3]); // April = 30
```

### When Should You Use an Array Initializer?

Use an initializer when:

- the full list is known in advance  
- the list will not change during the program  

Do **not** use an initializer when:

- values come from user input  
- values are calculated later  
- the size is not known ahead of time  


## Accessing Array Elements

```java
System.out.println(marks[2]);
System.out.println(names[0]);
System.out.println(menuPrices[menuPrices.length - 1]);
```

Index may be:

- a literal (`marks[4]`)
- a variable (`marks[i]`)
- an expression (`marks[x+1]`)

Remember:

```
nth element is at index n - 1
```

## Array Length

Every array has a built-in field called `length`, which tells you **how many elements** the array contains.

```java
System.out.println(marks.length);
```

This is essential when writing loops, because it prevents “going past the end” of the array.

### Why This Matters

If an array has 5 elements, the valid indices are:

```
0  1  2  3  4
```

So accessing:

```java
array[5];
```

will cause an **ArrayIndexOutOfBoundsException**, one of the most common errors when working with arrays.

For example, always use `length` when looping:

```java
for (int i = 0; i < marks.length; i++) {
    System.out.println(marks[i]);
}
```

This guarantees you stay within valid bounds.


<br>

# Practice Problems — Arrays

Each of the following problems strengthens your understanding of array creation, indexing, assignment, and basic data manipulation.  

Later problems increase in complexity and require more careful reasoning.


### Problem 1 — First and Last  
Create an `int[]` with 5 values representing cans collected by different homerooms.  
Print the first and last values in the array.

<br>

### Problem 2 — Favourite Songs  
Create a `String[]` storing your 5 favourite songs.  
Print the song in the middle of the list.

<br>

### Problem 3 — Menu Prices  
Create a `double[]` of 6 menu prices using an array initializer.  
Print the second-last price in the list.

<br>

### Problem 4 — Replace a Value  
Given the array:  
```java
int[] nums = {4, 8, 15, 16, 23, 42};
```  
Replace the value at index 2 with a new number.  
Print all values using a loop.

<br>

### Problem 5 — Swap  
Create an integer array of 5 elements.  
Swap the first element with the last.  
Print the array before and after the swap.

<br>

### Problem 6 — Manual Copy  
Create a `String[]` with 4 names.  
Create a second empty `String[]` of the same size.  
Copy each element from the first array into the second one manually, using direct index access.

<br>

### Problem 7 — Index Expressions  
Given:  
```java
double[] data = {1.5, 3.2, 4.8, 7.6, 9.1};
```  
Print the first element, the last element, the middle element, and one additional element chosen using an expression involving `data.length`.

<br>

### Problem 8 — Store and Reorder User Input  
Ask the user to enter **five** names.  
Store them inside a `String[]` of size 5.

Then print the names in the following order:

1. the **third** name entered  
2. the **first** name entered  
3. the **last** name entered  
4. the **second** name entered  
5. the **middle** name in the list  

Think carefully about the array positions. Try to write your solution so that it is value for an array of any size, not just hardcoded as 5.

<br>

### Problem 9 — Neighbour Differences

Given the array:

```java
int[] values = {12, 5, 9, 20, 7};
```

Create a **second** integer array that stores the **difference between neighbouring elements** in `values`.

For example, the first element of your new array should represent the difference between `values[0]` and `values[1]`, the second element should represent the difference between `values[1]` and `values[2]`, and so on.

Requirements:

- the new array should have a size based on `values.length`
- each position in the new array should store one neighbour difference
- print out **both** arrays with clear labelling so it is obvious which differences belong to which pair of values

Sample structure (your exact wording may differ):

```
Original: 12 5 9 20 7
Diffs:    7 4 11 13
```

Think carefully about how the indices of the new array relate to the indices of the original array.

<br>

### Problem 10 — Formatted Score Table
Given two related arrays:

```java
String[] players = {"Ana", "Ben", "Ming", "Hermione"};
int[] scores = {14, 22, 18, 31};
```

Print a properly aligned table where each player's name appears next to their score.

Requirements:

- ensure the **names are padded** so that the scores line up neatly  
- do **not** assume all names are the same length  
- use the relationship between the arrays (same index → same player)

Your output **should match the structure** of the sample below:

```
Ana       : 14
Ben       : 22
Ming      : 18
Hermione  : 31
```

Spacing must adjust automatically based on string lengths.

