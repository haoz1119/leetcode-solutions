# Last updated: 1/12/2026, 12:23:34 AM
class DSU:
    def __init__(self, n:int):
        self.parent = list(range(n)) # start with one being their own parent
        self.size = [1] * n
    def find(self, idx: int) -> int:
        if idx != self.parent[idx]:
            self.parent[idx] = self.find(self.parent[idx]) # parent path compression 
        return self.parent[idx]
    def union(self, i: int, j: int):
        ip, jp = self.find(i), self.find(j)
        if ip == jp:
            return
        if self.size[jp] > self.size[ip]: 
            ip, jp = jp, ip
        self.size[ip] += self.size[jp]
        self.parent[jp] = ip


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        if n == 1:
            return 1
        dsu = DSU(n)
        for i in range(n):
            for j in range(i+1,n,1):
                if isConnected[i][j] == 1:
                    dsu.union(i, j)
        return len({dsu.find(i) for i in range(n)})
