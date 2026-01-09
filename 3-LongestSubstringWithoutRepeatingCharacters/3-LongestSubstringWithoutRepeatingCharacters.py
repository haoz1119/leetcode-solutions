# Last updated: 1/8/2026, 11:00:06 PM
1class Solution:
2    def lengthOfLongestSubstring(self, s: str) -> int:
3        left = 0
4        maxl = 0
5        count = defaultdict(int)
6        for i, ch in enumerate(s):
7            count[ch] += 1
8            while count[ch] > 1:
9                count[s[left]] -= 1
10                left += 1
11            maxl = max(maxl, i - left + 1)
12        return maxl