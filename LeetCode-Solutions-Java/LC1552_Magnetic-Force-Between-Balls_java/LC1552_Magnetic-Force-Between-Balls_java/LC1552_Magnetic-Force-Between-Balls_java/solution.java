import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1, high = position[position.length - 1] - position[0];
        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Reduce the search space
            }
        }
        return result;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1, lastPos = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
                if (count == m) return true;
            }
        }
        return false;
    }
}
