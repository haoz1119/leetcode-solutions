# Last updated: 1/12/2026, 11:09:58 PM
1class Solution:
2    def coinChange(self, coins: List[int], amount: int) -> int:
3        dp = [math.inf]*(amount+1)
4        dp[0]=0
5        for coin in coins:
6            for i in range(coin,amount+1):
7                dp[i] = min(dp[i], dp[i-coin]+1)
8        return dp[amount] if dp[amount] != math.inf else -1