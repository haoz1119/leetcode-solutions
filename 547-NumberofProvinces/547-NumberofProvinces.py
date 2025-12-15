# Last updated: 12/15/2025, 2:01:35 PM
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
12            self.size[jp] += self.size[ip]
13            self.parent[ip] =  jp
14            self.size[ip] = 1
15        else:
16            self.size[ip] += self.size[jp]
17            self.parent[jp] = ip
18            self.size[jp] = 1
19
20
21class Solution:
22    def findCircleNum(self, isConnected: List[List[int]]) -> int:
23        n = len(isConnected)
24        if n == 1:
25            return 1
26        dsu = DSU(n)
27        for i in range(n):
28            for j in range(i+1,n,1):
29                if isConnected[i][j] == 1:
30                    dsu.union(i, j)
31        return len({dsu.find(i) for i in range(n)})
32