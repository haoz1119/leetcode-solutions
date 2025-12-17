# Last updated: 12/17/2025, 2:44:53 PM
1class Solution:
2    def subsets(self, nums: List[int]) -> List[List[int]]:
3        path = []
4        res = []
5        n = len(nums)
6        def backtrack(idx: int):
7            res.append(path.copy())
8            for i in range(idx, n): 
9                path.append(nums[i])
10                backtrack(i+1)
11                path.pop()
12        backtrack(0)
13        return res