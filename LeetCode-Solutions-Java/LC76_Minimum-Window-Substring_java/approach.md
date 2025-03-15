# Minimum Window Substring (LeetCode 76)

## Problem Statement
Given two strings `s` and `t`, return the **minimum window substring** of `s` such that every character in `t` (**including duplicates**) is included in the window. If no such substring exists, return an empty string `""`.

## Approach
We use the **Sliding Window** technique to efficiently find the minimum window containing all characters of `t`.

### **Step 1: Frequency Map of `t`**
- Create a **frequency map** `freqT` to store the count of characters in `t`.

### **Step 2: Sliding Window Variables**
- Two pointers: `left` and `right` to define the window.
- `count`: Tracks the number of valid characters in the window.
- `window`: HashMap to store the frequency of characters in the current window.
- `minLen` and `startIdx` to track the smallest valid substring.

### **Step 3: Expand the Window**
- Expand `right` pointer and include characters in `window`.
- If a character count matches `freqT`, increase `count`.

### **Step 4: Contract the Window**
- When `count` equals the size of `freqT`, try to minimize the window by moving `left`.
- If `left`-most character is essential for `t` and removing it causes a mismatch, decrease `count`.

### **Step 5: Return the Result**
- If `minLen` was updated, return `s.substring(startIdx, startIdx + minLen)`. Otherwise, return `""`.

## Complexity Analysis
- **Time Complexity:** `O(N)`, where `N` is the length of `s`. Each character is processed at most twice (once by `right`, once by `left`).
- **Space Complexity:** `O(K)`, where `K` is the number of distinct characters in `t` (used for the HashMaps).

## Dry Run
### **Example 1**
**Input:**  
```text
s = "ADOBECODEBANC", t = "ABC"
```

**Execution Steps:**
1. Expand right until `count == size(freqT)`, forming a valid window.
2. Shrink left pointer while maintaining validity.
3. Repeat until all possibilities are checked.

**Output:** `"BANC"`

### **Example 2**
**Input:**  
```text
s = "a", t = "a"
```
**Output:** `"a"`

### **Example 3**
**Input:**  
```text
s = "a", t = "aa"
```
**Output:** `""` (Not possible)

## Edge Cases Considered
- `s.length() < t.length()` → Return `""`
- Single character match (`s = "a", t = "a"`)
- Characters not in `s`
- Large strings for efficiency testing

