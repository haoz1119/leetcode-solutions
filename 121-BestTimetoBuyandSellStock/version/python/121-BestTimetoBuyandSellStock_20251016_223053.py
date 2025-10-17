# Last updated: 10/16/2025, 10:30:53 PM
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l = 0
        minp = prices[l]
        maxProfit = 0
        for r, p in enumerate(prices):
            minp = min(p, minp)
            maxProfit = max(p-minp, maxProfit)
        return maxProfit