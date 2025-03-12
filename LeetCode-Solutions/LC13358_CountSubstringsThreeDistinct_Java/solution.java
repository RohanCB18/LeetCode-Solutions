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
