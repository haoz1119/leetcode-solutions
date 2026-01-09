# Last updated: 1/8/2026, 10:29:42 PM
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
22                    if nei == c:
23                        return rcost*cost
24                    else:
25                        result = dfs(nei, c, visited)
26                        if result != -1.0:
27                            return rcost*cost*result
28            return -1.0
29                    
30        for a, c in queries:
31            visited = set()
32            res.append(dfs(a, c, visited))
33        return res
34            
35