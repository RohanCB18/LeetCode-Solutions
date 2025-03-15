# Minimum Capability to Steal from K Houses

## Problem Statement
Given an array `nums` representing the value of houses and an integer `k`, determine the **minimum maximum reward** a thief must have to successfully steal from exactly `k` houses, ensuring no two adjacent houses are robbed.

## Approach
We use **Binary Search** to efficiently determine the minimum required capability.

### **Step 1: Define Search Space**
- The thief's reward capability must be at least `1` (minimum possible value).
- The upper bound is the maximum value in `nums`, since that’s the worst-case reward requirement.

### **Step 2: Binary Search on Reward Capability**
1. **Choose `midReward`**: The middle value between `minReward` and `maxReward`.
2. **Simulate Stealing**:
   - Iterate through `nums`.
   - If `nums[i] <= midReward`, steal from house `i` and skip the next house (`i++`).
   - Count the total valid thefts.
3. **Update Search Space**:
   - If `possibleThefts >= k`, reduce `maxReward` to try a lower capability.
   - Else, increase `minReward` to find a feasible capability.

### **Step 3: Return the Result**
- The lowest possible `minReward` that allows exactly `k` houses to be robbed is the answer.

## Complexity Analysis
- **Time Complexity:** `O(N log M)`, where `N` is the number of houses and `M` is the max value in `nums`.
- **Space Complexity:** `O(1)`, since only a few integer variables are used.

## Dry Run
### **Example 1**
**Input:**  
```text
nums = [2,3,5,9], k = 2
```
**Execution:**
1. Binary search starts with `minReward = 1`, `maxReward = 9`.
2. Midpoint check reduces range iteratively until the minimum valid reward is found.
**Output:** `5`

### **Example 2**
**Input:**  
```text
nums = [1,2,3,4,5], k = 2
```
**Output:** `2`

## Edge Cases Considered
- `nums` contains duplicates.
- `k` is the smallest or largest possible.
- Large arrays for efficiency testing.

