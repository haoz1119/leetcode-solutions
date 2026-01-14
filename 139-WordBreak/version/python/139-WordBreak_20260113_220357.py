# Last updated: 1/13/2026, 10:03:57 PM
1class Solution:
2    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
3        n = len(s)
4        words = set(wordDict)
5        @lru_cache(None)
6        def dfs(start, end):
7            if s[start:end] not in words:
8                return False
9            if end == n:
10                return True
11            for i in range(end+1, n+1):
12                if dfs(end, i):
13                    return True
14            return False
15                
16        for i in range(1, n+1):
17            if dfs(0, i):
18                return True
19        return False