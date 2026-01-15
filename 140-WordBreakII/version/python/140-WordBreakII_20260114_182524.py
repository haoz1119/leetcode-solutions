# Last updated: 1/14/2026, 6:25:24 PM
1class Solution:
2    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
3        n = len(s)
4        words = set(wordDict)
5        max_len = max(len(w) for w in words)
6        dp = [False] * (n+1)
7        dp[0] = True
8        for i in range(1,n+1):
9            start = max(0, i-max_len)
10            dp[i] = any(dp[j] and s[j:i] in words for j in range(start, i))
11                
12        return dp[n]