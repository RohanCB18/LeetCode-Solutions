# Find First and Last Position of Element in Sorted Array (LeetCode 34)

## Approach: Binary Search
- We use **Binary Search** to efficiently locate the first and last occurrence of the target.
- First, perform a **binary search** to find the **first occurrence**.
- Then, perform another **binary search** to find the **last occurrence**.
- If the target is found, return `[first, last]`; otherwise, return `[-1, -1]`.

### **Steps:**
1. Use binary search to find the leftmost occurrence.
2. Use binary search to find the rightmost occurrence.
3. Return the indices as `[first, last]`.

## Complexity Analysis:
- **Time Complexity**: O(log n) (Binary search reduces search space exponentially).
- **Space Complexity**: O(1) (No extra space used).

## Example:
```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

## Dry Run:
### **Binary Search Execution**
| Step | low | high | mid | Value at mid | Action |
|------|-----|------|-----|-------------|--------|
| 1    | 0   | 5    | 2   | 7           | `7 < 8`, move `low = mid + 1` |
| 2    | 3   | 5    | 4   | 8           | First occurrence found at `4`, continue search left |
| 3    | 3   | 3    | 3   | 8           | First occurrence found at `3` |
| 4    | 0   | 5    | 2   | 7           | `7 < 8`, move `low = mid + 1` |
| 5    | 3   | 5    | 4   | 8           | Last occurrence found at `4` |

✅ Final result: `[3,4]`

