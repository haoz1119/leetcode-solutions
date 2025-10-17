# Last updated: 10/16/2025, 10:52:08 PM
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        seen = defaultdict(int)
        ml = 0
        for r, ch in enumerate(s):
            if seen[ch] == 0:
                ml = max(r-l+1, ml)
                seen[ch]+=1
            else:
                seen[ch]+=1
                while seen[ch]>1:
                    seen[s[l]]-=1
                    l+=1
        return ml