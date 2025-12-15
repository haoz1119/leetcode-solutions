# Last updated: 12/14/2025, 6:46:24 PM
1from collections import deque
2class Solution:
3    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
4        if numCourses == 1:
5            return [0]
6        if len(prerequisites) == 0:
7            return list(range(numCourses))
8        # build adj and indegree
9        adj = [[] for _ in range(numCourses)]
10        indegree = [0]*numCourses
11        for a, b in prerequisites:
12            adj[b].append(a)
13            indegree[a]+=1
14        # kahn algo
15        free_class = [i for i, v in enumerate(indegree) if v == 0]
16        order = free_class[:] # shallow copy??
17        queue = deque(free_class)
18        while queue:
19            pre = queue.popleft()
20            for nei in adj[pre]:
21                indegree[nei] -= 1
22                if indegree[nei] == 0:
23                    queue.append(nei)
24                    order.append(nei)
25
26        return order if len(order) == numCourses else []
27