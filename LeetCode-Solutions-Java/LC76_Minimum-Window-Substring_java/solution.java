import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Step 1: Store frequency of characters in t
        Map<Character, Integer> freqT = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding Window Variables
        int left = 0, minLen = Integer.MAX_VALUE, startIdx = 0;
        int count = 0;  // Tracks valid characters in the window
        Map<Character, Integer> window = new HashMap<>();

        // Step 3: Expand the window using a `for` loop
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If c is in t and its count in window is valid, increment count
            if (freqT.containsKey(c) && window.get(c).intValue() == freqT.get(c).intValue()) {
                count++;
            }

            // Step 4: Try to shrink the window from the left
            while (count == freqT.size()) {
                // Update the minimum window substring
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                // Remove leftmost character from window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If leftChar was part of t and is now less than required, decrement count
                if (freqT.containsKey(leftChar) && window.get(leftChar) < freqT.get(leftChar)) {
                    count--;
                }

                left++;  // Move left pointer
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
