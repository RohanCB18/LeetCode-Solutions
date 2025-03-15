import java.util.Arrays;

class Solution {
    public int minCapability(int[] nums, int k) {
        int minReward = 1;
        int maxReward = Arrays.stream(nums).max().getAsInt();
        int totalHouses = nums.length;

        while (minReward < maxReward) {
            int midReward = (minReward + maxReward) / 2;
            int possibleThefts = 0;

            for (int i = 0; i < totalHouses; ++i) {
                if (nums[i] <= midReward) {
                    possibleThefts += 1;
                    i++; // Skip the next house to maintain non-adjacency
                }
            }

            if (possibleThefts >= k) {
                maxReward = midReward; // Try reducing capability
            } else {
                minReward = midReward + 1; // Increase capability
            }
        }

        return minReward;
    }
}
