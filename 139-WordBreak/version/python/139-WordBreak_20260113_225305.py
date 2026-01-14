# Last updated: 1/13/2026, 10:53:05 PM
1class Solution:
2    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
3        dp = [False] * len(s)
4        for i in range(len(s)):
5            for word in wordDict:
6                # Handle out of bounds case
7                if i < len(word) - 1:
8                    continue
9
10                if i == len(word) - 1:
11                    if s[0:i+1] == word:
12                        dp[i] = True
13                        break
14                if dp[i - len(word)]:
15                    if s[i - len(word) + 1 : i + 1] == word:
16                        dp[i] = True
17                        break
18
19        return dp[-1]