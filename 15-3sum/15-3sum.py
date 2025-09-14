# Last updated: 9/14/2025, 12:55:07 PM
def twoSum(nums: List[int], ans: List[List[int]], i: int)-> None:
        hi = len(nums) - 1
        lo = i + 1
        while lo < hi:
            if nums[lo] + nums[hi] < -nums[i]:
                lo+=1
            elif nums[lo] + nums[hi] > -nums[i]:
                hi -= 1
            else:
                ans.append([nums[i], nums[lo], nums[hi]])
                while lo<hi and nums[lo] == nums[lo+1]:
                    lo+=1
                while hi>lo and nums[hi] == nums[hi-1]:
                    hi-=1
                lo+=1
                hi-=1
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort() # O(nlogn)
        ans = []
        for i in range(len(nums)):
            if nums[i] > 0: break
            # if nums[i]==nums[i-1], we have found all possible triplets for nums[i-1] so we can skip nums[i]
            elif i > 0 and nums[i] == nums[i-1]:
                continue
            else:
                twoSum(nums, ans, i)
        return ans

    
                