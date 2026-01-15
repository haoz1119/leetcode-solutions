# Last updated: 1/14/2026, 8:53:17 PM
1class Solution:
2    def longestCommonPrefix(self, strs: List[str]) -> str:
3        min_l = min(len(w) for w in strs)
4        for i in range(min_l):
5            ch = strs[0][i]
6            for j in range(1, len(strs)):
7                if strs[j][i] != ch:
8                    return strs[0][:i]
9        return strs[0][:min_l]