# Last updated: 10/24/2025, 9:58:16 PM
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        p = 1
        ans=[]
        for n in nums: # prefix run
            ans.append(p)
            p *= n
        suffix = 1
        for i in range(len(nums)-1,-1,-1):
            ans[i] = ans[i]*suffix
            suffix*=nums[i]
        return ans