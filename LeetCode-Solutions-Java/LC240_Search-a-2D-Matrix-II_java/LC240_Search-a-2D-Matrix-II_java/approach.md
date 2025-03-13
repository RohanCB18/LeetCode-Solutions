# Search a 2D Matrix II (LeetCode 240)

## Approach:
- This problem requires searching for a target in a **row-wise and column-wise sorted matrix**.
- We apply **Binary Search** on each row to check if the target is present.

### **Steps:**
1. Iterate through each row in the matrix.
2. Perform **Binary Search** on the row:
   - If found, return `true`.
   - Otherwise, continue searching in the next row.
3. If no match is found after checking all rows, return `false`.

## Complexity Analysis:
- **Binary Search on each row**: O(log m)
- **Total Complexity**: O(n log m), where `n` is the number of rows and `m` is the number of columns.
- **Space Complexity**: O(1) since no extra space is used.

## Example:
```
Input: matrix = [[1,  4,  7, 11, 15],
                 [2,  5,  8, 12, 19],
                 [3,  6,  9, 16, 22],
                 [10,13,14,17,24],
                 [18,21,23,26,30]]
       target = 8

Output: true
```

## Dry Run:
### **Binary Search Execution on Rows**
| Row | Elements        | Mid Value | Action |
|-----|---------------|-----------|--------|
| 1   | [1, 4, 7, 11, 15] | 7  | `7 < 8`, search right |
| 2   | [2, 5, 8, 12, 19] | 8  | **Found!** |

✅ Target **8** found in **Row 2** → Return `true`.

