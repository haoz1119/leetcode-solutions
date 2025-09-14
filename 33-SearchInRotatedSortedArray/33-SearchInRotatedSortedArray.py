# Last updated: 9/14/2025, 12:54:35 PM
class Solution:
    # divide it into two cases:
    # inflection point in the front half or the second half
    # 3 4 5 6 7 | 0 1 in the second half, front half is more ordered, so we check the front half 
    # 6 7 | 0 1 3 4 5 in the first half, second half is more ordered, so we check the second half
    # and we always check the more ordered half first, the remaining half is still a rotated sorted array
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left < right-1:
            mid = (left+right)//2
            # if nums[left] > target and nums[mid] > target and nums[right] < target:
            #     return -1
            if nums[left] < nums[mid]:
                if nums[left] <= target and nums[mid] >= target:
                    right = mid
                else:
                    left = mid
            else:
                if nums[mid]<= target and nums[right] >= target:
                    left = mid
                else:
                    right = mid
        if nums[left] == target:
            return left
        if nums[right] == target:
            return right
        return -1