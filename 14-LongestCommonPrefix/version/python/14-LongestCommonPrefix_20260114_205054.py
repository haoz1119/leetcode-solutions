# Last updated: 1/14/2026, 8:50:54 PM
1class Solution:
2    def longestCommonPrefix(self, strs: List[str]) -> str:
3        min_l = min(len(w) for w in strs)
4        res = ""
5        for i in range(min_l):
6            ch = strs[0][i]
7            for j in range(1, len(strs)):
8                if strs[j][i] != ch:
9                    return res
10            res += ch
11        return res