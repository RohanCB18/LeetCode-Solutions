// LeetCode 2529 - Maximum Count of Positive Integer and Negative Integer
// Approach 1: Binary Search to Find First Positive & Last Negative:


// Time Complexity: O(log n), Space Complexity: O(1)


// This approach uses two binary searches. The first finds the index of the first positive number, 
// and the second finds the index of the last negative number. The counts are then derived based 
// on these indices, and the maximum of the two is returned.

class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, firstPos = -1, lastNeg = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > 0) {
                firstPos = mid;
                right = mid - 1; // Move left to find first positive
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < 0) {
                lastNeg = mid;
                left = mid + 1; // Move right to find last negative
            } else {
                right = mid - 1;
            }
        }

        int countPos = (firstPos == -1) ? 0 : (n - firstPos);
        int countNeg = (lastNeg == -1) ? 0 : (lastNeg + 1);

        return Math.max(countPos, countNeg);
    }
}

/*
   Dry Run Example:
   Input: nums = [-5, -3, -2, 0, 0, 2, 4, 6]
   Step 1: Find first positive -> Index 5 (value 2), countPos = 3
   Step 2: Find last negative -> Index 2 (value -2), countNeg = 3
   Output: 3

   True/False Cases:
    nums = [-10, -5, -2, 1, 2, 3]  → Output: 3
    nums = [0, 0, 0]                → Output: 0
    nums = [-5, -3, -1]             → Output: 3
    nums = [1, 2, 3, 4]             → Output: 4
    nums = [] (empty array)         → Edge case, Output: 0
*/

---------------------------------------------------------------------------------------------

// Approach 2: Filtering Out Zeros First & Using Binary Search.

  
// Time Complexity: O(n) (filtering) + O(log n) (binary search) = O(n), Space Complexity: O(n)

  
// This approach first removes all zeros from the array, leaving only negative and positive numbers.
// A binary search is then applied to count negatives and positives separately. Finally, the 
// maximum count is returned.

import java.util.*;

class Solution {
    public int maximumCount(int[] nums) {
        // Step 1: Filter out zeros
        List<Integer> filteredList = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                filteredList.add(num);
            }
        }

        // Convert List to Array
        int[] filtered = filteredList.stream().mapToInt(i -> i).toArray();
        int n = filtered.length;
        int left = 0, right = n - 1, countPos = 0, countNeg = 0;

        // Step 2: Apply Binary Search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (filtered[mid] > 0) {
                countPos = n - mid; // Count all elements from mid to end
                right = mid - 1;
            } else {
                countNeg = mid + 1; // Count all elements from 0 to mid
                left = mid + 1;
            }
        }

        return Math.max(countPos, countNeg);
    }
}

/*
   Dry Run Example:
   Input: nums = [-5, -3, -2, 0, 0, 2, 4, 6]
   Step 1: Filter out zeros -> nums = [-5, -3, -2, 2, 4, 6]
   Step 2: Binary search finds:
           countNeg = 3 (first three elements)
           countPos = 3 (last three elements)
   Output: 3

   True/False Cases:
    nums = [-10, -5, -2, 1, 2, 3]  → Output: 3
    nums = [0, 0, 0]                → Output: 0
    nums = [-5, -3, -1]             → Output: 3
    nums = [1, 2, 3, 4]             → Output: 4
    nums = [] (empty array)         → Edge case, Output: 0
*/
