class Solution {
    // Approach 1: Binary Search to Find First Positive & Last Negative
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


import java.util.*;

class Solution2 {
    // Approach 2: Filtering Out Zeros First & Using Binary Search
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
