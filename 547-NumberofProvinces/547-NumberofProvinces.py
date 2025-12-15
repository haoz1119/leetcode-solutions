# Last updated: 12/15/2025, 2:29:14 PM
1class DSU:
2    def __init__(self, n:int):
3        self.parent = list(range(n)) # start with one being their own parent
4        self.size = [1] * n
5    def find(self, idx: int) -> int:
6        if idx != self.parent[idx]:
7            self.parent[idx] = self.find(self.parent[idx]) # parent path compression 
8        return self.parent[idx]
9    def union(self, i: int, j: int):
10        ip, jp = self.find(i), self.find(j)
11        if self.size[jp] > self.size[ip]: 
12            ip, jp = jp, ip
13        self.size[ip] += self.size[jp]
14        self.parent[jp] = ip
15
16
17class Solution:
18    def findCircleNum(self, isConnected: List[List[int]]) -> int:
19        n = len(isConnected)
20        if n == 1:
21            return 1
22        dsu = DSU(n)
23        for i in range(n):
24            for j in range(i+1,n,1):
25                if isConnected[i][j] == 1:
26                    dsu.union(i, j)
27        return len({dsu.find(i) for i in range(n)})
28