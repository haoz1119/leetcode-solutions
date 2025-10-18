# Last updated: 10/17/2025, 6:23:50 PM
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l = 0
        minl = len(nums)
        sum = 0
        found = False
        for r, n in enumerate(nums):
            sum+=n
            while sum >= target:
                found = True
                minl = min(minl, r-l+1)
                sum -= nums[l]
                l+=1
                
        if found:return minl
        else: return 0