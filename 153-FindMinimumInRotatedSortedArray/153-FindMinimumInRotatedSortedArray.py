# Last updated: 9/14/2025, 12:54:03 PM
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums)-1
        while left < right-1:
            if nums[left] < nums[right]:
                return nums[left]
            else:
                mid = (left+right)//2
                if nums[left] > nums[mid]:
                    right = mid
                else:
                    left = mid+1
        return min(nums[left],nums[right])