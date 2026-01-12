# Last updated: 1/12/2026, 12:23:06 AM
class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        def helper(i):
            if i == 1:
                return 0
            return (helper(i-1)+k)%i
        return helper(n)+1