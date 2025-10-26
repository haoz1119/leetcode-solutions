# Last updated: 10/25/2025, 10:52:25 PM
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l,r = 0, len(nums)-1
        mid = (l+r)//2
        while l <= r:
            if nums[mid] > target:
                r = mid - 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                return mid
            mid = (l+r)//2
        return -1