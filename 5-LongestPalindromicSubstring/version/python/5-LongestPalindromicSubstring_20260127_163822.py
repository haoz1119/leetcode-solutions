# Last updated: 1/27/2026, 4:38:22 PM
1class Solution:
2    def longestPalindrome(self, s: str) -> str:
3        n = len(s)
4        def expand(l, r):
5            while l >= 0 and r < n and s[l] == s[r]:
6                l -= 1
7                r += 1
8            return (r-l-1, l+1, r)
9        maxl = [0,0,0]
10        for i in range(n):
11            oddl, odl, odr = expand(i, i)
12            maxl = [oddl, odl, odr] if oddl > maxl[0] else maxl
13            evenl, evl, evr = expand(i, i+1)
14            maxl = [evenl, evl, evr] if evenl > maxl[0] else maxl
15        return s[maxl[1]:maxl[2]]