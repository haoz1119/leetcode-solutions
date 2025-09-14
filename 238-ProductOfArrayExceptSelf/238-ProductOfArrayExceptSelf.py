# Last updated: 9/14/2025, 12:53:47 PM
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        ans = [1]*len(nums)
        for i in range(1, len(nums)):
            ans[i] = ans[i-1]*nums[i-1]
        suffix = nums[len(nums)-1]
        for i in range(len(nums)-2, -1, -1):
            ans[i] = ans[i]*suffix
            suffix *= nums[i]
        return ans
            