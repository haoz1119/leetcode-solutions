# Last updated: 9/14/2025, 12:55:14 PM
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)<=1: return len(s)
        dic = {}
        maxl = -math.inf
        j = 0
        for i, ch in enumerate(s):
            if ch not in dic:
                dic[ch] = i+1
                maxl = max(maxl, i-j+1)
            else:
                j = max(dic[ch], j)
                dic[ch] = i + 1
                maxl = max(maxl, i-j+1)
        return maxl