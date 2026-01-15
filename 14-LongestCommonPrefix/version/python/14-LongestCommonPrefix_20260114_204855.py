# Last updated: 1/14/2026, 8:48:55 PM
1class Solution:
2    def longestCommonPrefix(self, strs: List[str]) -> str:
3        min_l = min(len(w) for w in strs)
4        res = ""
5        for i in range(min_l):
6            ch = strs[0][i]
7            for s in strs[1:]:
8                if s[i] != ch:
9                    return res
10            res += ch
11        return res