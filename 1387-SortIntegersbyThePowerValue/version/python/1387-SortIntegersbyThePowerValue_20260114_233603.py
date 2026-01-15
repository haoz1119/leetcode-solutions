# Last updated: 1/14/2026, 11:36:03 PM
1from functools import cache
2class Solution:
3    def getKth(self, lo: int, hi: int, k: int) -> int:
4        dic = {}
5        @cache
6        def dfs(n):
7            if n == 1:
8                return 0
9            if n % 2 == 0:
10                return 1 + dfs(n//2)
11            else:
12                return 1 + dfs(3*n+1)
13        for n in range(lo, hi+1):
14            dic[n] = dfs(n)
15        return sorted(dic.keys(), key=dic.get)[k-1]
16