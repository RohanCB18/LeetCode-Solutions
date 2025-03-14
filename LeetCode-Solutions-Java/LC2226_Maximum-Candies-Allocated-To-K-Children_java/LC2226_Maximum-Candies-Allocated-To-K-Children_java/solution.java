
---

###  **`solution.java`**
```java
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1, high = getMax(candies);
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(candies, k, mid)) {
                result = mid;  // Mid is a valid answer, try for a larger value
                low = mid + 1;
            } else {
                high = mid - 1; // Mid is too large, reduce the search space
            }
        }
        return result;
    }

    // Function to check if we can allocate 'mid' candies to at least 'k' children
    private boolean canDistribute(int[] candies, long k, int mid) {
        long count = 0;
        for (int candy : candies) {
            count += (candy / mid);
        }
        return count >= k;  // If we can distribute to at least k children, return true
    }

    // Function to get the maximum value from the candies array
    private int getMax(int[] candies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }
}
