# Rearrange Array Elements by Sign (LeetCode 2149)

## Approach: Two Pointers
- We need to **rearrange an array** such that **positive and negative numbers alternate**, maintaining their relative order.
- **Two pointers** are used:
  - `posIndex` starts at index `0` for positives.
  - `negIndex` starts at index `1` for negatives.
- **Iteration logic:**
  - If the number is **positive**, place it at `posIndex` and increase `posIndex` by 2.
  - If the number is **negative**, place it at `negIndex` and increase `negIndex` by 2.

## Complexity Analysis:
- **Time Complexity**: O(n) (Single pass through the array).
- **Space Complexity**: O(n) (Extra array for rearrangement).

## Example:
```
Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
```

## Dry Run:
### **Step-by-Step Execution**
| Step | Current Element | Action | ans[] After Step |
|------|----------------|--------|-----------------|
| 1    | 3              | Place at posIndex=0 | [3, _, _, _, _, _] |
| 2    | 1              | Place at posIndex=2 | [3, _, 1, _, _, _] |
| 3    | -2             | Place at negIndex=1 | [3, -2, 1, _, _, _] |
| 4    | -5             | Place at negIndex=3 | [3, -2, 1, -5, _, _] |
| 5    | 2              | Place at posIndex=4 | [3, -2, 1, -5, 2, _] |
| 6    | -4             | Place at negIndex=5 | [3, -2, 1, -5, 2, -4] |

Final result: `[3,-2,1,-5,2,-4]`

