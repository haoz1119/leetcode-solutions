# Last updated: 1/8/2026, 10:54:46 PM
1class Solution:
2    def lengthOfLongestSubstring(self, s: str) -> int:
3        left = 0
4        maxl = 0
5        last_seen = {}
6        for i, ch in enumerate(s):
7            if ch not in last_seen:
8                last_seen[ch] = i
9            elif ch in last_seen:
10                if last_seen[ch] >= left:
11                    left = last_seen[ch] + 1
12                last_seen[ch] = i
13            maxl = max(maxl, i - left + 1)
14        return maxl