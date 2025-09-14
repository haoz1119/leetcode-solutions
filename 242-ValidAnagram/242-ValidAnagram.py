# Last updated: 9/14/2025, 12:53:46 PM
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        cnt=[0]*26
        cnt_t=[0]*26
        for ch in s:
            cnt[ord(ch)-ord('a')]+=1
        for ch in t:
            cnt_t[ord(ch)-ord('a')]+=1
        for i in range(0,26):
            if cnt[i]!=cnt_t[i]:return False
        return True