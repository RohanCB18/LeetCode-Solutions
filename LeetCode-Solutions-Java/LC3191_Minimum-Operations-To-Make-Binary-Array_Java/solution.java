class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int left = 0, count = 0, ops = 0;

        for (int i = 0; i <= n - 3; i++) {  // Ensure valid window
            if (nums[i] == 0) {  
                // Flip the entire window of size 3
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ops++;  
            }

            // Maintain the sliding window of size 3
            count++;
            if (count == 3) {
                count = 0;  // Reset count
                left++;  // Move left pointer forward
                i = left - 1;  // Restart from new left
            }
        }

        // Final check if all elements are 1
        for (int num : nums) {
            if (num == 0) return -1;
        }

        return ops;
    }
}
