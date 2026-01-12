# Last updated: 1/12/2026, 12:23:30 AM
class DSU:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.size = [1]*n
    def find(self, i: int):
        if self.parent[i] != i:
            self.parent[i] = self.find(self.parent[i])
        return self.parent[i]

    def union(self, i: int, j: int)->bool:
        ir, jr = self.find(i), self.find(j)
        if ir == jr:
            return True
        if self.size[ir] > self.size[jr]:
            ir, jr = jr, ir
        self.parent[ir] = jr
        self.size[jr] += self.size[ir]
        return False
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        dsu = DSU(n+1)
        for i, j in edges:
            if dsu.union(i, j):
                return [i, j]
            
        return []