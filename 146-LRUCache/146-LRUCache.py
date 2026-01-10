# Last updated: 1/10/2026, 12:06:25 AM
1class Solution:
2    def findTheWinner(self, n: int, k: int) -> int:
3        def helper(i):
4            if i == 1:
5                return 0
6            return (helper(i-1)+k)%i
7        return helper(n)+1