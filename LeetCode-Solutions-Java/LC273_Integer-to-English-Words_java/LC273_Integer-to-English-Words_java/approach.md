# Integer to English Words (LeetCode 273)

## Approach: Recursion and String Concatenation
- The problem requires converting an integer into its **English word representation**.
- We break down the number into parts (Billions, Millions, Thousands, etc.) and convert each part recursively.

### **Steps:**
1. **Define number groups** (below ten, below twenty, below hundred).
2. **Base cases**:
   - If `num == 0`, return "Zero".
   - If `num < 10`, return from `belowTen`.
   - If `num < 20`, return from `belowTwenty`.
   - If `num < 100`, combine `belowHundred[num/10]` and the remainder.
3. **Recursive division**:
   - If `num >= 1000`, process **Thousand**.
   - If `num >= 1,000,000`, process **Million**.
   - If `num >= 1,000,000,000`, process **Billion**.
4. **Recursively concatenate the word representation**.

## Complexity Analysis:
- **Time Complexity**: O(log n) (Recursive calls reduce the number size).
- **Space Complexity**: O(log n) (Recursive stack usage).

## Example:
```
Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
```

## Dry Run:
### **Recursive Execution for `num = 12345`**
| Step | Number | Function Call | Output |
|------|--------|--------------|--------|
| 1    | 12345  | `numberToWords(12345)` | "Twelve Thousand" |
| 2    | 345    | `numberToWords(345)`   | "Three Hundred Forty Five" |
| 3    | Final  | Combine results        | "Twelve Thousand Three Hundred Forty Five" |

 Final result: `"Twelve Thousand Three Hundred Forty Five"`

