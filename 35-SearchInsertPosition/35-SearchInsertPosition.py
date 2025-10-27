# Last updated: 10/26/2025, 7:20:46 PM
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l, r = 0, len(nums)
        while l < r:
            mid = (l+r)//2
            if nums[mid]>=target:
                r = mid
            else:
                l = mid+1
        start = l
        l, r = 0, len(nums)
        while l < r:
            mid = (l+r)//2
            if nums[mid]>target:
                r = mid
            else:
                l = mid+1
        end = l-1
        return [start,end] if start != len(nums) and nums[start]==target else [-1,-1]