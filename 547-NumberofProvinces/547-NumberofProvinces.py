# Last updated: 12/15/2025, 2:30:44 PM
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
11        if ip == jp:
12            return
13        if self.size[jp] > self.size[ip]: 
14            ip, jp = jp, ip
15        self.size[ip] += self.size[jp]
16        self.parent[jp] = ip
17
18
19class Solution:
20    def findCircleNum(self, isConnected: List[List[int]]) -> int:
21        n = len(isConnected)
22        if n == 1:
23            return 1
24        dsu = DSU(n)
25        for i in range(n):
26            for j in range(i+1,n,1):
27                if isConnected[i][j] == 1:
28                    dsu.union(i, j)
29        return len({dsu.find(i) for i in range(n)})
30