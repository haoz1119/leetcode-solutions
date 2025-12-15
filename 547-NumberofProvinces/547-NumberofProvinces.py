# Last updated: 12/15/2025, 3:24:44 PM
1class DSU:
2    def __init__(self, n: int):
3        self.parent = list(range(n))
4        self.size = [1]*n
5    def find(self, i: int):
6        if self.parent[i] != i:
7            self.parent[i] = self.find(self.parent[i])
8        return self.parent[i]
9
10    def union(self, i: int, j: int)->bool:
11        ir, jr = self.find(i), self.find(j)
12        if ir == jr:
13            return True
14        if self.size[ir] > self.size[jr]:
15            ir, jr = jr, ir
16        self.parent[ir] = jr
17        self.size[jr] += self.size[ir]
18        return False
19class Solution:
20    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
21        n = len(edges)
22        dsu = DSU(n+1)
23        for i, j in edges:
24            if dsu.union(i, j):
25                return [i, j]
26            
27        return []