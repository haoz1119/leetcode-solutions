# Last updated: 12/24/2025, 7:44:57 PM
1from collections import deque
2class Solution:
3    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
4        pacificset = set()
5        atlanticset = set()
6        m = len(heights)
7        n = len(heights[0])
8        queue = deque()
9        def inbound(nr, nc):
10            return (0<= nr < m) and (0 <= nc < n)
11        drs = [(1,0),(-1,0),(0,1),(0,-1)]
12        for j in range(n):
13            if (0, j) not in pacificset:
14                pacificset.add((0,j))
15                queue.append((0, j))
16            while queue:
17                r, c = queue.popleft()
18                cur_height = heights[r][c]
19                for dr, dc in drs:
20                    nr, nc = r+dr, c+dc
21                    if inbound(nr, nc) and heights[nr][nc] >= cur_height and (nr, nc) not in pacificset: 
22                        pacificset.add((nr,nc))
23                        queue.append((nr, nc))
24        for i in range(1, m):
25            if (i, 0) not in pacificset:
26                pacificset.add((i, 0))
27                queue.append((i, 0))
28            while queue:
29                r, c = queue.popleft()
30                cur_height = heights[r][c]
31                for dr, dc in drs:
32                    nr, nc = r+dr, c+dc
33                    if inbound(nr, nc) and heights[nr][nc] >= cur_height and (nr, nc) not in pacificset: 
34                        pacificset.add((nr,nc))
35                        queue.append((nr, nc))
36        aqueue = deque()
37        for j in range(n):
38            if (m-1, j) not in atlanticset:
39                atlanticset.add((m-1 ,j))
40                aqueue.append((m-1, j))
41            while aqueue:
42                r, c = aqueue.popleft()
43                cur_height = heights[r][c]
44                for dr, dc in drs:
45                    nr, nc = r+dr, c+dc
46                    if inbound(nr, nc) and heights[nr][nc] >= cur_height and (nr, nc) not in atlanticset: 
47                        atlanticset.add((nr,nc))
48                        aqueue.append((nr, nc))
49        for i in range(0, m-1):
50            if (i, n-1) not in atlanticset:
51                atlanticset.add((i ,n-1))
52                aqueue.append((i, n-1))
53            while aqueue:
54                r, c = aqueue.popleft()
55                cur_height = heights[r][c]
56                for dr, dc in drs:
57                    nr, nc = r+dr, c+dc
58                    if inbound(nr, nc) and heights[nr][nc] >= cur_height and (nr, nc) not in atlanticset: 
59                        atlanticset.add((nr,nc))
60                        aqueue.append((nr, nc))
61        return list(atlanticset.intersection(pacificset))