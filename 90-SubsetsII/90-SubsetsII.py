# Last updated: 12/24/2025, 8:57:58 PM
1class Solution:
2    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
3        path = []
4        res = []
5        nums.sort()
6        n = len(nums)
7        def backtrack(start):
8            res.append(path.copy())
9            for i in range(start, n):
10                if i > start and nums[i] == nums[i-1]:
11                    continue
12                path.append(nums[i])
13                backtrack(i+1)
14                path.pop()
15        backtrack(0)
16        return res
17