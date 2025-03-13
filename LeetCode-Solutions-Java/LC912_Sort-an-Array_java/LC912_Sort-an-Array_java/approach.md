# Sort an Array (LeetCode 912)

## Approach:
We use **Merge Sort**, a **Divide and Conquer** algorithm. The array is **recursively divided** into two halves until each subarray contains a single element. The `conquer` function **merges** two sorted subarrays efficiently.

### **Recursive Call Tree for Merge Sort**
```
               divide(0,5) → [6,3,9,5,2,8]
               /       \
      divide(0,2)      divide(3,5)
      [6,3,9]          [5,2,8]
      /       \        /       \
  divide(0,1)  (2,2)  divide(3,4)  (5,5)
  [6,3]       [9]     [5,2]       [8]
  /     \       |       /    \
(0,0)  (1,1)  (2,2)  (3,3)  (4,4)  (5,5)
[6]     [3]    [9]    [5]    [2]    [8]

   Merging:
   (0,0) + (1,1) → Merge [6] and [3] → [3, 6]
   (3,3) + (4,4) → Merge [5] and [2] → [2, 5]

   (0,1) + (2,2) → Merge [3, 6] and [9] → [3, 6, 9]
   (3,4) + (5,5) → Merge [2, 5] and [8] → [2, 5, 8]

   (0,2) + (3,5) → Merge [3, 6, 9] and [2, 5, 8] → [2, 3, 5, 6, 8, 9]
```

### **Complexity Analysis:**
- **Time Complexity**: O(n log n) (due to recursive divisions).
- **Space Complexity**: O(n) (temporary array used for merging).

