# Last updated: 12/14/2025, 5:53:28 PM
1from collections import deque
2class Solution:
3    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
4        if numCourses == 1 or len(prerequisites) == 0: return True
5        adj = {}
6        indegree = {}
7        # build adj and indegree
8        for a, b in prerequisites:
9            if b not in adj:
10                adj[b] = []
11            adj[b].append(a)
12            if a not in indegree:
13                indegree[a] = 0
14            indegree[a] += 1
15            if b not in indegree:
16                indegree[b] = 0
17        # kahn's algorithm
18        free_class = [key for key, v in indegree.items() if v == 0]
19        queue = deque(free_class)
20        while queue:
21            pre = queue.popleft()
22            if pre in adj:
23                for nei in adj[pre]:
24                    indegree[nei] -= 1
25                    if indegree[nei] == 0:
26                        queue.append(nei)
27        return True if sum(indegree.values()) == 0 else False
28        
29
30