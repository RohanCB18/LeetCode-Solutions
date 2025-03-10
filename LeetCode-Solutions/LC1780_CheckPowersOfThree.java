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
