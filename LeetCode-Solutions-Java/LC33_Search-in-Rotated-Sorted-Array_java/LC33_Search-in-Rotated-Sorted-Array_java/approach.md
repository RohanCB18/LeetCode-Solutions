# Search in Rotated Sorted Array (LeetCode 33)

## Approach: Binary Search
- The array is **sorted but rotated** at some pivot.
- We use **Binary Search** to determine which half is sorted and decide where to search next.

### **Steps:**
1. Initialize `low = 0`, `high = n - 1`.
2. Find `mid = (low + high) / 2`.
3. Check if `nums[mid] == target`, return `mid` if true.
4. Determine which half is sorted:
   - **If `nums[low] ≤ nums[mid]`**, the **left half is sorted**.
     - If `target` lies in this half, move `high = mid - 1`, else move `low = mid + 1`.
   - **Else**, the **right half is sorted**.
     - If `target` lies in this half, move `low = mid + 1`, else move `high = mid - 1`.
5. Continue until `low > high`.
6. If not found, return `-1`.

## Complexity Analysis:
- **Time Complexity**: O(log n) (Binary Search halves the search space).
- **Space Complexity**: O(1) (No extra space used).

## Example:
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

## Dry Run:
### **Binary Search Execution**
| Step | low | high | mid | nums[mid] | Action |
|------|-----|------|-----|----------|--------|
| 1    | 0   | 6    | 3   | 7        | Left half sorted, search right |
| 2    | 4   | 6    | 5   | 1        | Right half sorted, search left |
| 3    | 4   | 4    | 4   | 0        | Found! Return `4` |

✅ Final result: `4`

