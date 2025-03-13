# Search a 2D Matrix (LeetCode 74)

## Approach:
- We treat the **2D matrix as a 1D sorted array** and apply **Binary Search**.
- Compute row and column indices using:
  ```
  row = mid / columns
  col = mid % columns
  ```
- Adjust search space (`low` and `high`) based on comparisons.

## Complexity Analysis:
- **Time Complexity**: O(log (n * m)) → Binary search on `n * m` elements.
- **Space Complexity**: O(1) → No extra space used.

## Example:
```
Input: matrix = [[1, 2, 3, 4],
                 [5, 6, 7, 8],
                 [9, 10, 11, 12]]
       target = 8

Output: true
```

## Dry Run:
### **Binary Search Execution**
| Step | low | high | mid | row, col | Value | Action |
|------|-----|------|-----|----------|-------|--------|
| 1    | 0   | 11   | 5   | (1,1)    | 6     | `6 < 8`, move `low = mid + 1` |
| 2    | 6   | 11   | 8   | (2,0)    | 9     | `9 > 8`, move `high = mid - 1` |
| 3    | 6   | 7    | 6   | (1,2)    | 7     | `7 < 8`, move `low = mid + 1` |
| 4    | 7   | 7    | 7   | (1,3)    | 8     | **Found!** |

