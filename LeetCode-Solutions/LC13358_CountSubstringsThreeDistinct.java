/* 
 LeetCode 13358 - Count Substrings with Three Distinct Characters  
 Difficulty: Medium  

 Problem Statement:  
Given a string `s`, count the number of substrings that contain **at least** three distinct characters.  

 Example:  
Input: s = "abcabc"  
Output: 10  
Explanation: The valid substrings are:  
- "abc", "abca", "abcab", "abcabc"  
- "bca", "bcab", "bcabc"  
- "cab", "cabc"  
- "abc"  

 Approach:  
- We can Use a **sliding window** to efficiently track the character counts.  
- Maintain a **hashmap** to store the frequency of characters in the current window.  
- Expand the window to include new characters, remove a character from left, add one to the right, and it gpes on.  
- When the window contains at least **3 distinct characters**, count all valid substrings.  
- Shrink the window from the left to maintain the condition.  

Time Complexity: O(n) → The string is processed in a single pass.  
Space Complexity: O(1) → At most 3 characters are stored in the hashmap.  
*/

import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {  
        int n = s.length();
        if (n < 3) return 0; // No valid substrings possible

        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        for (int i = 0; i < n; i++) {  
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // When at least 3 distinct characters are present, count substrings
            while (freq.size() == 3) {  
                count += (n - i); // Count all substrings ending at i

                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++; // Shrink window
            }
        }
        return count;
    }
}

/*  
Dry Run Examples:  

 **Case 1: Example Input**  
Input: s = "abcabc"  
Output: 10  

Step-by-Step Execution:  

1️ **Substring `"abc"` found** (window: `"abc"`)  
   -  New substrings: `"abc"`, `"abca"`, `"abcab"`, `"abcabc"`  
   -  count += 4 → **Total: 4**  

2️ **Substring `"bca"` found** (window: `"bca"`)  
   -  New substrings: `"bca"`, `"bcab"`, `"bcabc"`  
   -  count += 3 → **Total: 7**  

3️ **Substring `"cab"` found** (window: `"cab"`)  
   -  New substrings: `"cab"`, `"cabc"`  
   -  count += 2 → **Total: 9**  

4️ **Substring `"abc"` found** (window: `"abc"`)  
   -  New substring: `"abc"`  
   -  count += 1 → **Total: 10**  

Final **Output: 10**   

---

 **Case 2: No Valid Substrings**  
Input: s = "aaaa"  
Output: 0  

Step-by-Step Execution:  
- The string contains only 'a', so no valid substrings exist.  

Since no substring has 3 distinct characters, return `0`.  
*/
