# Last updated: 1/1/2026, 3:42:56 PM
1class Solution:
2    def coinChange(self, coins: List[int], amount: int) -> int:
3        if amount == 0: return 0
4        dp = [float('inf')]*(amount+1)
5        dp[0] = 0
6        for coin in coins:
7            for i in range(coin, amount+1):
8                dp[i] = min(dp[i], 1+dp[i - coin])
9
10        return dp[amount] if dp[amount] != float('inf') else -1