/* 
🎯 LeetCode 1780 - Check if Number is a Sum of Three Powers of Three
🔹 Difficulty: Medium

📝 Problem Statement:
Given an integer `n`, return **true** if it can be represented as the sum of three distinct powers of 3, otherwise return **false**.

📌 Example:
Input: n = 12
Output: true
Explanation: 12 = 3^0 + 3^1 + 3^2

🔍 Approach:
- First step is to Convert `n` into **base-3 representation**.
- If any digit in base-3 is **2**, then return `false` (because we can not use the same power twice).
- Otherwise, return `true`.

⏳ Time Complexity: O(log n) → `n` reduces by a factor of 3 in each step.
💾 Space Complexity: O(1) → No extra space used.
*/

class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false; // If remainder is 2, we can't form n using distinct powers of 3
            n /= 3; // Reduce n by dividing by 3
        }
        return true;
    }
}

/*
 Dry Run Examples:

 Case 1: True Example
Input: n = 12

Step-by-Step Execution:
1. n = 12 → 12 % 3 = 0 (valid) → n = 12 / 3 = 4
2. n = 4  → 4 % 3 = 1 (valid)  → n = 4 / 3 = 1
3. n = 1  → 1 % 3 = 1 (valid)  → n = 1 / 3 = 0 (end)

Since all digits in base-3 were 0 or 1, returns **true**.



 Case 2: False Example
Input: n = 21

Step-by-Step Execution:
1. n = 21 → 21 % 3 = 0 (valid) → n = 21 / 3 = 7
2. n = 7  → 7 % 3 = 1 (valid)  → n = 7 / 3 = 2
3. n = 2  → 2 % 3 = **2 (not allowed!)** → return **false**.

 Since a digit in base-3 was `2`, return **false**.
*/
