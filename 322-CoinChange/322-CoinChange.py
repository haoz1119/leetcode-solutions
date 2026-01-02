# Last updated: 1/1/2026, 4:43:43 PM
1class Solution:
2    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
3        n = len(s)
4        word = set(wordDict)
5        dp = [False] * (n+1)
6        dp[0] = True
7        for i in range(1,n+1):
8            dp[i] = any(dp[j] and s[j:i] in word for j in range(i))
9                
10        return dp[n]