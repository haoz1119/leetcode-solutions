# Last updated: 10/20/2025, 2:55:28 PM
class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        l = 0
        ma = float("-inf")
        sums = 0
        for r, n in enumerate(nums):
            sums+=n
            if r>=k:
                sums-=nums[l]
                l+=1 
            if r >= k-1:
                ma = max(ma, sums/(r-l+1))
        return ma