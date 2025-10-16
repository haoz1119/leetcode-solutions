# Last updated: 10/15/2025, 9:03:26 PM
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums)<3: return []
        def twoSum(l:int, target:int, nums:List[int])->List[Tuple[int]]:
            r = len(nums)-1
            pair = []
            while l < r:
                if nums[l]+nums[r] == target:
                    pair.append((nums[l], nums[r]))
                    l+=1
                    r-=1
                elif nums[l]+nums[r] > target:
                    r-=1
                else: l+=1
            return pair
        nums.sort()
        result=[]
        s = set()
        for i, num in enumerate(nums):
            pair = twoSum(i+1, -nums[i], nums)
            if len(pair) == 0:
                continue
            else:
                for p in pair:
                    s.add((nums[i],)+p)
        return list(s)