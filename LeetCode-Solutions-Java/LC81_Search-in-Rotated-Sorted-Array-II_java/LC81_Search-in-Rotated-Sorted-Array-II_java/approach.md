# Search in Rotated Sorted Array II (LeetCode 81)

## Approach: Modified Binary Search (Handles Duplicates)
- Similar to **LeetCode 33**, but we now handle **duplicate values**.
- Duplicates can make it unclear which half is sorted, so we need an extra check.

### **Steps:**
1. Initialize `low = 0`, `high = n - 1`.
2. Find `mid = (low + high) / 2`.
3. If `nums[mid] == target`, return `true`.
4. Handle duplicate cases:
   - If `nums[low] == nums[mid] == nums[high]`, reduce search space by **`low++` and `high--`**.
5. Otherwise, determine which half is sorted:
   - **If `nums[low] ≤ nums[mid]`**, the **left half is sorted**.
     - If `target` lies in this half, move `high = mid - 1`, else move `low = mid + 1`.
   - **Else**, the **right half is sorted**.
     - If `target` lies in this half, move `low = mid + 1`, else move `high = mid - 1`.
6. Continue until `low > high`.
7. If not found, return `false`.

## Complexity Analysis:
- **Worst Case Time Complexity**: O(n) (Occurs when many duplicates exist, reducing one by one).
- **Best/Average Case**: O(log n) (When binary search operates normally).
- **Space Complexity**: O(1) (No extra space used).

## Example:
```
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
```

## Dry Run:
### **Binary Search Execution**
| Step | low | high | mid | nums[mid] | Action |
|------|-----|------|-----|----------|--------|
| 1    | 0   | 6    | 3   | 0        | Found! Return `true` |

 Final result: `true`

