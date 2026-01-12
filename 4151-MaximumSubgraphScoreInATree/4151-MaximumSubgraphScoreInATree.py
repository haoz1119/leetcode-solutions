# Last updated: 1/12/2026, 12:23:01 AM
from typing import List

class Solution:
    def maxSubgraphScore(self, n: int, edges: List[List[int]], good: List[int]) -> List[int]:
        val = [1 if g else -1 for g in good]
        adj = [[] for _ in range(n)]
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)

        best_down = [0] * n

        def dfs(u: int, p: int) -> None:
            total = val[u]
            for v in adj[u]:
                if v == p:
                    continue
                dfs(v, u)
                total += max(0, best_down[v])
            best_down[u] = total

        dfs(0, -1)

        res = [0] * n
        res[0] = best_down[0]

        def reroot(u: int, p: int) -> None:
            for v in adj[u]:
                if v == p:
                    continue
                from_parent = res[u] - max(0, best_down[v])
                total = val[v] + max(0, from_parent)
                for w in adj[v]:
                    if w == u:
                        continue
                    total += max(0, best_down[w])
                res[v] = total
                reroot(v, u)

        reroot(0, -1)
        return res