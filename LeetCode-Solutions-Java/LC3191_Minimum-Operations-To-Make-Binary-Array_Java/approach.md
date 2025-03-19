## **Approach for LeetCode 3191: Minimum Operations to Make Binary Array Elements Equal to One**

### ** Problem Understanding**
Given a binary array `nums` containing `0s` and `1s`, you can **flip exactly three consecutive elements at a time** (i.e., `0 → 1` and `1 → 0`). The goal is to determine the **minimum number of operations** required to make all elements `1`. If it's **not possible**, return `-1`.

---

### ** Approach**
1. **Use a Sliding Window of Size 3:**
   - Traverse the array and check for `0`.
   - If a `0` is found at index `i`, flip the **three elements** starting from `i` (`nums[i]`, `nums[i+1]`, `nums[i+2]`).
   - Count this operation.

2. **Use `left` Pointer to Manage the Sliding Window:**
   - After processing a window of 3 elements, move `left++`.
   - Reset `i` to `left - 1` to continue checking from the correct position.

3. **Check for Completion:**
   - After traversing, if any `0` remains in `nums`, return `-1`.
   - Otherwise, return the minimum number of operations performed.

---

### **🔹 Dry Run Example**
#### **Input:**
```plaintext
nums = {0, 1, 0, 1, 0, 1}
```
#### **Execution Steps:**
| Step | nums Array | Ops Count | Left Moves To | i Resets To |
|------|-----------|----------|---------------|-------------|
| Start | `{0, 1, 0, 1, 0, 1}` | 0 | 0 | 0 |
| Flip `{0, 1, 0}` | `{1, 0, 1, 1, 0, 1}` | 1 | 1 | `left-1 = 0` |
| Flip `{0, 1, 1}` | `{1, 1, 1, 1, 0, 1}` | 2 | 2 | `left-1 = 1` |
| Flip `{0, 1, 1}` | `{1, 1, 1, 1, 1, 1}` | 3 | 3 | `left-1 = 2` |
| **Final Check** | `{1, 1, 1, 1, 1, 1}` |  Success | — | — |

 **All elements are converted to `1` in `3` operations!**  

---

### ** Time & Space Complexity**
- **Time Complexity:** `O(n)`, as we traverse the array efficiently.
- **Space Complexity:** `O(1)`, since we modify the array in place.

---

### ** Summary**
 **Uses a sliding window approach to minimize operations.**  
 **Ensures all elements are converted to `1` efficiently.**  
 **Handles edge cases where `0` might still remain.**  

---

This structured approach guarantees the **minimum operations** needed to transform the array! 🚀

