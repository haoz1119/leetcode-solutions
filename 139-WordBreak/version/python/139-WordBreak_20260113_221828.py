# Last updated: 1/13/2026, 10:18:28 PM
1class Solution:
2    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
3        @cache
4        def dp(i):
5            if i < 0:
6                return True
7
8            for word in wordDict:
9                if s[i - len(word) + 1 : i + 1] == word and dp(i - len(word)):
10                    return True
11
12            return False
13
14        return dp(len(s) - 1)