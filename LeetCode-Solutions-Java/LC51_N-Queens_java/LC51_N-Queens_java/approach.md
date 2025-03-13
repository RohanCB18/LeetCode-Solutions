# N-Queens (LeetCode 51)

## Approach: Backtracking
- The problem requires placing `n` queens on an `n x n` chessboard such that **no two queens attack each other**.
- We use **backtracking** to explore possible placements column by column.

### **Steps:**
1. **Use a recursive function** to try placing a queen in each column.
2. **Check safety** before placing a queen (no attack in row, column, or diagonals).
3. **If a valid placement is found**, move to the next column.
4. **Backtrack** by removing the last placed queen and trying the next possible row.
5. **If all queens are placed**, store the board configuration.

## Complexity Analysis:
- **Time Complexity**: O(N!) (Each row has fewer valid choices as we proceed)
- **Space Complexity**: O(N^2) (Board representation and recursion stack)

## Example:
```
Input: n = 4
Output:
[
  [".Q..",  // Solution 1
   "...Q",
   "Q...",
   "..Q."],

  ["..Q.",  // Solution 2
   "Q...",
   "...Q",
   ".Q.."]
]
```

## Dry Run:
### **Backtracking Execution for `n = 4`**
| Step | Current Board | Action |
|------|--------------|--------|
| 1    | Place `Q` in row 0, col 0 | Move to col 1 |
| 2    | Place `Q` in row 1, col 1 | Conflict! Backtrack |
| 3    | Place `Q` in row 2, col 1 | Move to col 2 |
| 4    | Place `Q` in row 3, col 2 | Conflict! Backtrack |
| 5    | Try placing `Q` in different rows | Continue solving |

Final result: **2 valid board configurations**

