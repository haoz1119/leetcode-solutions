# Last updated: 1/14/2026, 5:51:29 PM
1class Solution:
2    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
3        n = len(s)
4        words = set(wordDict)
5        max_len = max(len(w) for w in words)
6        
7        # dp[i] = True if s[0:i] can be segmented
8        dp = [False] * (n + 1)
9        dp[0] = True
10        
11        # dps[i] = list of all valid sentences for s[0:i]
12        dps = [[] for _ in range(n + 1)]
13        dps[0] = [""]  # Initialize with empty string for uniform handling
14        
15        for i in range(1, n + 1):
16            start = max(0, i - max_len)  # Only check words within max_len
17            for j in range(start, i):
18                if dp[j] and s[j:i] in words:
19                    word = s[j:i]
20                    dps[i] += [f"{sentence} {s[j:i]}".strip() for sentence in dps[j]]
21            
22            # Mark position i as reachable if we found any valid sentences
23            if dps[i]:
24                dp[i] = True
25        
26        return dps[n]