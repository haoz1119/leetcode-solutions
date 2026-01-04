# Last updated: 1/3/2026, 9:16:09 PM
1class Solution:
2    def isAnagram(self, s: str, t: str) -> bool:
3        cnt=[0]*26
4        cnt_t=[0]*26
5        for ch in s:
6            cnt[ord(ch)-ord('a')]+=1
7        for ch in t:
8            cnt_t[ord(ch)-ord('a')]+=1
9        return cnt==cnt_t
10        