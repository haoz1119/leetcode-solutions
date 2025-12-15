# Last updated: 12/14/2025, 5:57:46 PM
1from collections import deque
2class Solution:
3    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
4        if numCourses == 1 or len(prerequisites) == 0: return True
5        adj = {}
6        indegree = [0]*numCourses
7        # build adj and indegree
8        for a, b in prerequisites:
9            if b not in adj:
10                adj[b] = []
11            adj[b].append(a)
12            indegree[a] += 1
13        # kahn's algorithm
14        free_class = [key for key, v in enumerate(indegree) if v == 0]
15        taken = len(free_class)
16        queue = deque(free_class)
17        while queue:
18            pre = queue.popleft()
19            if pre in adj:
20                for nei in adj[pre]:
21                    indegree[nei] -= 1
22                    if indegree[nei] == 0:
23                        queue.append(nei)
24                        taken += 1
25        return taken == numCourses
26        
27
28