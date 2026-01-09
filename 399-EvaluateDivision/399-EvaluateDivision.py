# Last updated: 1/8/2026, 9:15:03 PM
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
13        def bfs(a, c):
14            if a not in adj or c not in adj:
15                return -1.0
16            if a == c:
17                return 1.0
18            queue = deque([(a, 1)])
19            visited = set()
20            visited.add(a)
21            while queue:
22                node, rcost = queue.popleft()
23                for nei, cost in adj[node]:
24                    if nei not in visited:
25                        visited.add(nei)
26                        if nei == c:
27                            rcost *= cost
28                            return rcost
29                        else:
30                            queue.append((nei, rcost*cost))
31            return -1.0
32        for a, c in queries:
33            res.append(bfs(a, c))
34        return res
35            
36