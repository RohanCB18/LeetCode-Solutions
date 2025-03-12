# LeetCode 1780 - Check if Number is a Sum of Three Powers of Three

## Problem Statement:
Given an integer `n`, return **true** if it can be represented as the sum of three distinct powers of 3, otherwise return **false**.

### **Example:**
#### **Input:**
```plaintext
n = 12
```
#### **Output:**
```plaintext
true
```
#### **Explanation:**
12 = 3^0 + 3^1 + 3^2

---

## **Approach:**
1. Convert `n` into **base-3 representation**.
2. If any digit in base-3 is **2**, return `false` (because we cannot use the same power twice).
3. Otherwise, return `true`.

### **Complexity Analysis:**
- **Time Complexity:** `O(log n)` → `n` reduces by a factor of 3 in each step.
- **Space Complexity:** `O(1)` → No extra space used.

---

## **Dry Run Examples:**

### **Case 1: True Example**
#### **Input:**
```plaintext
n = 12
```
#### **Step-by-Step Execution:**
1. `n = 12` → `12 % 3 = 0` (valid) → `n = 12 / 3 = 4`
2. `n = 4`  → `4 % 3 = 1` (valid)  → `n = 4 / 3 = 1`
3. `n = 1`  → `1 % 3 = 1` (valid)  → `n = 1 / 3 = 0` (end)

Since all digits in base-3 were `0` or `1`, returns **true**.

---

### **Case 2: False Example**
#### **Input:**
```plaintext
n = 21
```
#### **Step-by-Step Execution:**
1. `n = 21` → `21 % 3 = 0` (valid) → `n = 21 / 3 = 7`
2. `n = 7`  → `7 % 3 = 1` (valid)  → `n = 7 / 3 = 2`
3. `n = 2`  → `2 % 3 = 2` (**not allowed!**) → return **false**.

Since a digit in base-3 was `2`, return **false**.

