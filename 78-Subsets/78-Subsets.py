# Last updated: 12/17/2025, 3:38:30 PM
1class Solution:
2    def combine(self, n: int, k: int) -> List[List[int]]:
3        path = []
4        res = []
5
6        def backtrack(start: int)-> None:
7            if len(path) == k:
8                res.append(path[:])
9                return
10            remaining_slots = k - len(path)
11            for i in range(start, n - remaining_slots+1):
12                path.append(i+1)
13                backtrack(i+1)
14                path.pop()
15
16        backtrack(0)  
17        return res