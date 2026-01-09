# Last updated: 1/8/2026, 10:27:39 PM
1from collections import defaultdict, deque
2class Solution:
3    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
4        # build adj list
5        n = len(equations)
6        adj = defaultdict(list)
7        for i in range(n):
8            a, b = equations[i]
9            adj[a].append((b, values[i]))
10            adj[b].append((a, 1/values[i]))
11        # bfs to find for each query
12        res = []
13        def dfs(a, c, visited):
14            if a not in adj or c not in adj:
15                return -1.0
16            if a == c:
17                return 1.0
18            rcost = 1
19            visited.add(a)
20            for nei, cost in adj[a]:
21                if nei not in visited:
22                    visited.add(nei)
23                    if nei == c:
24                        return rcost*cost
25                    else:
26                        result = dfs(nei, c, visited)
27                        if result != -1.0:
28                            return rcost*cost*result
29            return -1.0
30                    
31        for a, c in queries:
32            visited = set()
33            res.append(dfs(a, c, visited))
34        return res
35            
36