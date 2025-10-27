# Last updated: 10/26/2025, 7:24:47 PM
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0: return [-1,-1]
        l, r = 0, len(nums)-1
        while l <= r:
            mid = (l+r)//2
            if nums[mid]>=target:
                r = mid-1
            else:
                l = mid+1
        start = l
        l, r = 0, len(nums)-1
        while l <= r:
            mid = (l+r)//2
            if nums[mid]>target:
                r = mid-1
            else:
                l = mid+1
        end = l-1
        return [start,end] if start != len(nums) and nums[start]==target else [-1,-1]