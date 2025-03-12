# LeetCode 13358 - Count Substrings with Three Distinct Characters

## Problem Statement:
Given a string `s`, count the number of substrings that contain **at least** three distinct characters.

### **Example:**
#### **Input:**
```plaintext
s = "abcabc"
```
#### **Output:**
```plaintext
10
```
#### **Explanation:**
The valid substrings are:
- "abc", "abca", "abcab", "abcabc"
- "bca", "bcab", "bcabc"
- "cab", "cabc"
- "abc"

---

## **Approach:**
We can use a **sliding window** to efficiently track the character counts.

1. Maintain a **hashmap** to store the frequency of characters in the current window.
2. Expand the window to include new characters.
3. When the window contains at least **3 distinct characters**, count all valid substrings ending at the current index.
4. Shrink the window from the left while maintaining the condition.

### **Complexity Analysis:**
- **Time Complexity:** `O(n)` → The string is processed in a single pass.
- **Space Complexity:** `O(1)` → At most 3 characters are stored in the hashmap.

---

## **Dry Run Examples:**

### **Case 1: Example Input**
#### **Input:**
```plaintext
s = "abcabc"
```
#### **Output:**
```plaintext
10
```
#### **Step-by-Step Execution:**

1️ **Substring "abc" found** (window: "abc")  
   - New substrings: "abc", "abca", "abcab", "abcabc"  
   - `count += 4` → **Total: 4**

2️ **Substring "bca" found** (window: "bca")  
   - New substrings: "bca", "bcab", "bcabc"  
   - `count += 3` → **Total: 7**

3️ **Substring "cab" found** (window: "cab")  
   - New substrings: "cab", "cabc"  
   - `count += 2` → **Total: 9**

4️ **Substring "abc" found** (window: "abc")  
   - New substring: "abc"  
   - `count += 1` → **Total: 10**

Final **Output: 10**

---

### **Case 2: No Valid Substrings**
#### **Input:**
```plaintext
s = "aaaa"
```
#### **Output:**
```plaintext
0
```
#### **Step-by-Step Execution:**
- The string contains only 'a', so no valid substrings exist.
- Since no substring has 3 distinct characters, return `0`. 

