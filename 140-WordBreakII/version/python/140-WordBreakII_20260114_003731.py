# Last updated: 1/14/2026, 12:37:31 AM
1class Solution:
2    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
3        n = len(s)
4        words = set(wordDict)
5        max_len = max(len(w) for w in words)
6        dp = [False] * (n+1)
7        dp[0] = True
8        dps = [[] for _ in range(n+1)] 
9        result = []
10        for i in range(1,n+1):
11            start = max(0, i-max_len)
12            for j in range(start, i):
13                if dp[j] and s[j:i] in words:
14                    if dps[j]:
15                        for st in dps[j]:
16                            dps[i].append(f"{st} {s[j:i]}")
17                    else:
18                        dps[i].append(s[j:i])
19                    dp[i] = True
20        return dps[n]