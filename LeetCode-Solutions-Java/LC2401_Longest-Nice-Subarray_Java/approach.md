## **Approach for LeetCode 2401: Longest Nice Subarray**

### ** Problem Understanding**
We are given an array `nums`, and we need to find the **longest contiguous subarray** such that the **bitwise AND of any two elements in the subarray is 0**. This means no two elements in the subarray should have common set bits (`1s`).

---

### ** Approach (Sliding Window + Bitmasking)**
1. **Use a Sliding Window (`left` and `right` pointers)**:
   - Expand the window by moving `right`.
   - If adding `nums[right]` to the current window violates the condition (i.e., `(bitmask & nums[right]) != 0`), then **shrink the window from the left**.
   
2. **Maintain a `bitmask` to track used bits in the window**:
   - `bitmask |= nums[right]` → Adds the new element to the window.
   - `bitmask ^= nums[left]` → Removes elements when needed.
   
3. **Update the maximum length (`maxLen`)** whenever the window is valid.

---

### ** Dry Run Example**
#### **Input:**
```plaintext
nums = [1, 3, 8, 48, 10]
```
#### **Execution Steps:**
| Step | `left` | `right` | `nums[right]` | `bitmask` (Binary) | Valid? | `maxLen` |
|------|--------|---------|--------------|------------------|--------|----------|
| 1    | 0      | 0       | 1            | `0001`           |  Yes  | 1        |
| 2    | 0      | 1       | 3            | `0011`           |  Yes  | 2        |
| 3    | 0      | 2       | 8            | `1011`           |  Yes  | 3        |
| 4    | 0      | 3       | 48           | `11011`          |  Yes  | 4        |
| 5    | 0      | 4       | 10           | `110101`         |  No   | 4        |
| 6    | 1      | 4       | 10           | `110100`         |  No   | 4        |
| 7    | 2      | 4       | 10           | `110000`         |  Yes  | 4        |

✔ **Final Answer: `4`** 

---

### ** Time & Space Complexity**
- **Time Complexity:** `O(n)`, since each element is processed at most twice (once when added, once when removed).
- **Space Complexity:** `O(1)`, as only a few integer variables are used.

---

### ** Summary**
**Uses a sliding window approach to efficiently find the longest subarray.**  
**Bitmasking ensures quick validity checks and updates.**  
**Optimized to `O(n)` time complexity.**  

---

This structured approach guarantees the **optimal solution** for the problem! 

