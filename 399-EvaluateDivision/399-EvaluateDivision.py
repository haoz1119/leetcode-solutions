# Last updated: 1/9/2026, 4:32:12 PM
1from collections import defaultdict, deque
2class Solution:
3    def calcEquation(
4        self, equations: List[List[str]], values: List[float], queries: List[List[str]]
5    ) -> List[float]:
6        # Build adjacency list
7        adj = defaultdict(list)
8        for i, (a, b) in enumerate(equations):
9            adj[a].append((b, values[i]))
10            adj[b].append((a, 1 / values[i]))
11
12        res = []
13
14        def dfs(a: str, c: str) -> float:
15            if a not in adj or c not in adj:
16                return -1.0
17            if a == c:
18                return 1.0
19            visited.add(a)
20            for nei, cost in adj[a]:
21                if nei not in visited:
22                    result = dfs(nei, c)
23                    if result != -1.0:
24                        return cost * result
25            return -1.0
26
27        for a, c in queries:
28            visited = set()  # Reset for each query
29            res.append(dfs(a, c))
30        return res
31