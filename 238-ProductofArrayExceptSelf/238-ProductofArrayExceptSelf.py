# Last updated: 10/24/2025, 9:47:39 PM
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefixp = {}
        p = 1
        ans=[]
        for i, n in enumerate(nums):
            prefixp[i] = p
            p *= n
        suffixp={}
        p = 1
        l = len(nums)
        for i, n in enumerate(nums[::-1]):
            suffixp[l-1-i] = p
            p *= n
            
        for i in range(len(nums)):
            ans.append(prefixp[i]*suffixp[i])
        return ans