# LeetCode 37 - Sudoku Solver

## **Problem Statement**
Given a `9×9` Sudoku board represented as a 2D array, solve it by filling the empty cells (`.`) following the rules:
1. Each row must contain digits `1-9` **without repetition**.
2. Each column must contain digits `1-9` **without repetition**.
3. Each `3×3` subgrid must contain digits `1-9` **without repetition**.

---

## **Approach: Backtracking with Constraint Checking**
- We use **backtracking** to try filling each empty cell (`.`) with numbers `1-9`.
- For each placement, we check if it follows the Sudoku rules.
- If valid, proceed to the next empty cell.
- If stuck, **backtrack** by removing the last placed number and trying the next option.
- Repeat until the board is solved.

---

## **Algorithm**
1. **Find the first empty cell (`.`).**
2. **Try placing numbers from `1-9`.**
   - If `isValid(board, row, col, num) == true`, place the number.
   - Recur to solve the next empty cell.
   - If successful, return true.
   - If unsuccessful, reset cell to `.` (backtrack).
3. **Continue until the board is completely filled.**

---

## **Function Details**
### **`isValid(board, row, col, num)`**
- Checks whether placing `num` at `board[row][col]` follows the Sudoku rules:
  1. **Row check** → Ensure `num` is not already in the same row.
  2. **Column check** → Ensure `num` is not already in the same column.
  3. **3×3 subgrid check** → Ensure `num` is not in the corresponding 3×3 grid.

---

## **Complexity Analysis**
- **Backtracking worst case:** `O(9^N)`, where `N` is the number of empty cells.
- **Optimized by constraint checking before recursion.**

---

## **Example Walkthrough**
### **Input:**
```java
char[][] board = {
  {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
};
```
### **Step-by-Step Execution**
- Start at `board[0][2]` → Try `1` (valid).
- Move to the next empty cell.
- If no number works, **backtrack** and try the next number.
- Continue filling until board is solved.

### **Final Output:**
A fully solved Sudoku board with all constraints met.

