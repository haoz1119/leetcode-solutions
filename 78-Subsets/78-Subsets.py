# Last updated: 12/17/2025, 3:12:40 PM
1class Solution:
2    def combine(self, n: int, k: int) -> List[List[int]]:
3        path = []
4        res = []
5
6        def backtrack(start: int)-> None:
7            if len(path) == k:
8                res.append(path[:])
9                return
10            for i in range(start, n):
11                path.append(i+1)
12                backtrack(i+1)
13                path.pop()
14
15        backtrack(0)  
16        return res