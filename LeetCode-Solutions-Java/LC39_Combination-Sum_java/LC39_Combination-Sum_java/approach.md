# Combination Sum (LeetCode 39)

## Approach: Backtracking
- The goal is to find **all unique combinations** where the sum equals the target.
- A number **can be used multiple times** in a combination.
- **Backtracking** is used to explore all possible combinations.

### **Steps:**
1. Start from index `0` and recursively explore candidates.
2. If the sum reaches `target`, store the combination.
3. If the sum exceeds `target`, backtrack (remove last element).
4. Continue exploring by including the same number (since numbers can be reused).
5. Move to the next index after trying all possibilities for a number.

## Complexity Analysis:
- **Time Complexity**: O(2^t * k) (where `t` is target, `k` is average length of a combination).
- **Space Complexity**: O(k * x) (where `x` is the number of valid combinations).

## Example:
```
Input: candidates = [2, 3, 6, 7], target = 7
Output: [[2,2,3], [7]]
```

## Dry Run:
### **Backtracking Execution**
| Step | Current Path (`ds`) | Remaining Target | Action |
|------|--------------------|------------------|--------|
| 1    | []                 | 7                | Start recursion |
| 2    | [2]                | 5                | Include `2` |
| 3    | [2, 2]             | 3                | Include `2` |
| 4    | [2, 2, 2]          | 1                | Include `2` |
| 5    | [2, 2, 2, 2]       | -1               | Invalid (Backtrack) |
| 6    | [2, 2, 3]          | 0                | **Valid Combination** |
| 7    | [7]                | 0                | **Valid Combination** |

Final result: `[[2,2,3], [7]]`

