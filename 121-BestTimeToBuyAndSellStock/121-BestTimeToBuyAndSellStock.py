# Last updated: 9/14/2025, 12:54:18 PM
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxP = 0
        minP= math.inf
        for p in prices:
            minP = min(p, minP)
            maxP= max(p-minP, maxP)
        return maxP