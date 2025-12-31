# Last updated: 12/31/2025, 10:30:10 AM
1class Solution:
2    def climbStairs(self, n: int) -> int:
3        prev0 = 1
4        prev1 = 1
5        i = 1
6        while n > 1 and i < n:
7            cur = prev0 + prev1
8            prev0, prev1 = prev1, cur
9            i += 1
10        return prev1