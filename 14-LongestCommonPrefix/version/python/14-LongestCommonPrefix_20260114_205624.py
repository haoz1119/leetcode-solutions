# Last updated: 1/14/2026, 8:56:24 PM
1class Solution:
2    def longestCommonPrefix(self, strs: List[str]) -> str:
3        if not strs:
4            return ""
5        min_l = min(len(w) for w in strs)
6        for i in range(min_l):
7            ch = strs[0][i]
8            for j in range(1, len(strs)):
9                if strs[j][i] != ch:
10                    return strs[0][:i]
11        return strs[0][:min_l]