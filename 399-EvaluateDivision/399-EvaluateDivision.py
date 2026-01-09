# Last updated: 1/8/2026, 10:33:57 PM
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
13        def dfs(a, c):
14            if a not in adj or c not in adj:
15                return -1.0
16            if a == c:
17                return 1.0
18            visited.add(a)
19            for nei, cost in adj[a]:
20                if nei not in visited:
21                    if nei == c:
22                        return cost
23                    else:
24                        result = dfs(nei, c)
25                        if result != -1.0:
26                            return cost*result
27            return -1.0
28                    
29        for a, c in queries:
30            visited = set()
31            res.append(dfs(a, c))
32        return res
33            
34