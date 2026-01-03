# Last updated: 1/2/2026, 10:08:49 PM
1from functools import lru_cache
2class Solution:
3    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
4        n = len(s)
5        words = set(wordDict)
6        min_len = min(len(w) for w in words)
7        max_len = max(len(w) for w in words)
8        @lru_cache(None)
9        def dfs(start, end):
10            if s[start:end] not in words:
11                return False
12            if end == n:
13                return True
14            for i in range(end+min_len, min(n, end+max_len)+1):
15                if dfs(end, i):
16                    return True
17            return False
18                
19        for i in range(1, n+1):
20            if dfs(0, i):
21                return True
22        return False