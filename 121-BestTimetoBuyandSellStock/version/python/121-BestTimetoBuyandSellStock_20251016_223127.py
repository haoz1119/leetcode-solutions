# Last updated: 10/16/2025, 10:31:27 PM
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minp = prices[0]
        maxProfit = 0
        for p in prices:
            minp = min(p, minp)
            maxProfit = max(p-minp, maxProfit)
        return maxProfit