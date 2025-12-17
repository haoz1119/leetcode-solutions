# Last updated: 12/17/2025, 3:00:39 PM
1class Solution:
2    def subsets(self, nums: List[int]) -> List[List[int]]:
3        path = []
4        res = []
5        n = len(nums)
6        def backtrack(idx: int):
7            res.append(path.copy())
8            for i in range(idx, n):
9                path.append(nums[i])   # choose nums[i] as the next element
10                backtrack(i + 1)       # now choose further elements only from i+1 onward
11                path.pop()             # unchoose nums[i], so we can try the next i
12        backtrack(0)
13        return res