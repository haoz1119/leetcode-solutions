# Last updated: 1/2/2026, 9:56:19 PM
1from functools import lru_cache
2class Solution:
3    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
4        n = len(s)
5        words = set(wordDict)
6        min_len = min(len(w) for w in words)
7        max_len = max(len(w) for w in words)
8        @lru_cache(None)
9        def dfs(start, end):
10            if end - start < min_len : return False
11            if end - start > max_len : return False
12            if s[start:end] not in words:
13                return False
14            if end == n:
15                return True
16            for i in range(end+1, n+1):
17                if dfs(end, i):
18                    return True
19            return False
20                
21        for i in range(1, n+1):
22            if dfs(0, i):
23                return True
24        return False