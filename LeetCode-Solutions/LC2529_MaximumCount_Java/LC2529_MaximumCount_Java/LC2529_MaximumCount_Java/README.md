# LeetCode 2529 - Maximum Count of Positive Integer and Negative Integer

## Approach 1: Binary Search to Find First Positive & Last Negative

### **Explanation**
- This approach uses two binary searches:
  1. **First search** finds the **first positive number**.
  2. **Second search** finds the **last negative number**.
- The counts are derived from these indices, and the **maximum** of the two is returned.

### **Complexity Analysis**
- **Time Complexity:** `O(log n)`  
- **Space Complexity:** `O(1)`

### **Dry Run Example**
#### **Input:**
```cpp
nums = [-5, -3, -2, 0, 0, 2, 4, 6]
```
#### **Execution Steps:**
1. **Find first positive** → Index `5` (value `2`), `countPos = 3`
2. **Find last negative** → Index `2` (value `-2`), `countNeg = 3`
3. **Output:** `3`

### **Test Cases**
| Input | Output |
|-------------------------|--------|
| `[-10, -5, -2, 1, 2, 3]` | `3` |
| `[0, 0, 0]` | `0` |
| `[-5, -3, -1]` | `3` |
| `[1, 2, 3, 4]` | `4` |
| `[]` (empty array) | `0` |

---

## Approach 2: Filtering Out Zeros First & Using Binary Search

### **Explanation**
- This approach **removes all zeros** from the array, leaving only **negative and positive numbers**.
- A **binary search** is then used to count negatives and positives separately.
- The **maximum count** is returned.

### **Complexity Analysis**
- **Time Complexity:** `O(n) (filtering) + O(log n) (binary search) = O(n)`
- **Space Complexity:** `O(n) (for storing filtered array)`

### **Dry Run Example**
#### **Input:**
```cpp
nums = [-5, -3, -2, 0, 0, 2, 4, 6]
```
#### **Execution Steps:**
1. **Filter out zeros** → `[-5, -3, -2, 2, 4, 6]`
2. **Binary search** finds:
   - `countNeg = 3` (first three elements)
   - `countPos = 3` (last three elements)
3. **Output:** `3`

### **Test Cases**
| Input | Output |
|-------------------------|--------|
| `[-10, -5, -2, 1, 2, 3]` | `3` |
| `[0, 0, 0]` | `0` |
| `[-5, -3, -1]` | `3` |
| `[1, 2, 3, 4]` | `4` |
| `[]` (empty array) | `0` |

