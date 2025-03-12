class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        lower_bound = len(nums)
        s, e = 0, len(nums) - 1
        while s <= e:
            mid = (s + e) // 2
            if nums[mid] < 0:
                s = mid + 1
            else:
                e = mid - 1
                lower_bound = mid
        

        upper_bound = len(nums)
        s,e = 0, len(nums) - 1
        while s <= e:
            mid = (s + e) // 2
            if nums[mid] > 0:
                e = mid - 1
                upper_bound = mid
            else:
                s = mid + 1
        
        return max(lower_bound, len(nums) - upper_bound)
        