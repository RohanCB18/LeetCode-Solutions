# Magnetic Force Between Two Balls (LeetCode 1552)

## Approach: Binary Search on Minimum Distance
- We need to place `m` balls in `arr.length` positions such that the **minimum magnetic force** (minimum distance between any two balls) is maximized.
- This suggests a **Binary Search on the possible minimum distances**.

### **Steps:**
1. **Sort the positions** to ensure increasing order.
2. **Apply Binary Search** on the possible minimum distance between balls:
   - **Low** = 1 (smallest possible distance).
   - **High** = `positions[n-1] - positions[0]` (largest possible distance).
3. **Check if placing `m` balls is possible for a given `mid` distance:**
   - Place the first ball at `positions[0]`.
   - Continue placing balls **only if the next valid position is at least `mid` distance apart**.
   - If we can place `m` balls, increase `low = mid + 1`.
   - Otherwise, decrease `high = mid - 1`.
4. The **maximum valid `mid`** is our answer.

## Complexity Analysis:
- **Sorting Complexity**: O(n log n)
- **Binary Search Complexity**: O(log(maxDist) * n)
- **Total Complexity**: O(n log n)

## Example:
```
Input: positions = [1, 2, 3, 4, 7], m = 3
Output: 3
```

## Dry Run:
### **Binary Search Execution**
| Step | low | high | mid | Can Place? | Action |
|------|-----|------|-----|------------|--------|
| 1    | 1   | 6    | 3   | Yes        | Increase low |
| 2    | 4   | 6    | 5   | No         | Decrease high |
| 3    | 4   | 4    | 4   | No         | Decrease high |

 Maximum distance: `3`

