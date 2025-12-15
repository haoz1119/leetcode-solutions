# Last updated: 12/14/2025, 5:39:06 PM
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
19        taken = len(free_class)
20        queue = deque(free_class)
21        while queue:
22            pre = queue.popleft()
23            if pre in adj:
24                for nei in adj[pre]:
25                    indegree[nei] -= 1
26                    if indegree[nei] == 0:
27                        queue.append(nei)
28                        taken += 1
29        return True if sum(indegree.values()) == 0 else False
30        
31
32