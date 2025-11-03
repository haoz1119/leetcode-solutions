# Last updated: 11/2/2025, 8:32:47 PM
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1
        if nums[l]<nums[r]:return nums[l]
        while l < r: 
            mid = (l+r)//2
            if nums[mid] > nums[r]: # [l, mid] is known, now we narrow to [mid+1, r]
                l = mid+1
            else: # [mid, r] is known, we narrow to [l, mid] since mid is smaller side we include it
                r = mid
        return nums[l]