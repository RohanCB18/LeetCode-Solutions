class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        if k > min(nums): return -1

        numset = set(nums)
        
        n = len(numset)
        
        if k in numset: return n - 1
        else: return n
