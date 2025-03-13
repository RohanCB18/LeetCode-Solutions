# Longest Substring Without Repeating Characters (LeetCode 3)

## Approach:
- Use **Sliding Window** technique.
- Maintain a **Set<Character>** to track unique characters.
- Expand the window (`right++`).
- If a duplicate appears, shrink from the left (`left++`).
- Keep track of the max window size.

## Complexity:
- **Time Complexity**: O(n)
- **Space Complexity**: O(min(n, 26)) → At most 26 characters in English alphabet.

## Example:
```
Input: "abcabcbb"
Output: 3
```
- **Valid substrings**: `"abc"`, `"bca"`, `"cab"` → All length `3`.

