class Solution {
    public boolean binarySearch(int[] nums, int target) {
        int n = nums.length; // Size of the array
        int low = 0, high = n - 1;
        
        // Perform the steps:
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (binarySearch(matrix[i], target)) return true;
        }
        return false;
    }
}
