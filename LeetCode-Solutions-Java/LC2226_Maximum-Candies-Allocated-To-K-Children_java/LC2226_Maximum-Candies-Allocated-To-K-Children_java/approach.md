# LeetCode 2226 - Maximum Candies Allocated to K Children

## **Problem Statement**
Given an array `candies[]`, where `candies[i]` represents the number of candies in the `i-th` pile, and an integer `k` (number of children), find the **maximum number of candies each child can receive** such that:
1. Each child gets **exactly one pile of the same number of candies**.
2. The number of children receiving candies is **at least `k`**.

---

## **Approach: Binary Search on Answer**
- We perform **binary search** on the possible number of candies each child can receive.
- The **minimum possible allocation** is `1`, and the **maximum possible allocation** is `max(candies)`.
- We check if we can allocate **mid** candies per child and adjust the search range.

---

## **Algorithm**
1. **Set the search range:**  
   - `low = 1`, `high = max(candies)`.
2. **Binary Search:**
   - Find `mid = (low + high) / 2` (potential allocation).
   - Check if at least `k` children can receive `mid` candies.
   - If possible, increase the allocation (`low = mid + 1`).
   - Otherwise, reduce the allocation (`high = mid - 1`).
3. **Final result** → `high` holds the maximum possible candies each child can get.

---

## **Complexity Analysis**
- **Binary search complexity:** `O(log M)`, where `M = max(candies)`.
- **Checking feasibility complexity:** `O(N)`, where `N` is the number of piles.
- **Total Complexity:** `O(N log M)`

---

## **Example Walkthrough**
### **Input:**
```java
candies = [5, 7, 9], k = 3
```
### **Binary Search Steps**
| mid | Can Distribute? | Adjust Range |
|----|--------------|------------|
| 4  |  Yes (5/4 + 7/4 + 9/4 = 1+1+2 = 4 ≥ 3) | Increase `low` |
| 6  |  No (5/6 + 7/6 + 9/6 = 0+1+1 = 2 < 3) | Decrease `high` |
| 5  |  Yes (5/5 + 7/5 + 9/5 = 1+1+1 = 3 = 3) | Increase `low` |

### **Final Answer:**  
```java
5
```

