# Last updated: 10/16/2025, 11:12:38 PM
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)<=1: return len(s)
        dic = defaultdict(int)
        maxl = 0
        j = 0
        for i, ch in enumerate(s):
            j = max(dic[ch], j)
            dic[ch] = i + 1
            maxl = max(maxl, i-j+1)
        return maxl