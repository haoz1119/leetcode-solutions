# Last updated: 12/10/2025, 2:31:32 PM
1from collections import deque
2class Solution:
3    def numIslands(self, grid: List[List[str]]) -> int:
4        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
5        def inbound(r, c, m, n):
6            return (r >= 0 and r < m) and (c >= 0 and c < n)
7        def bfs():
8            while queue:
9                i, j = queue.popleft()
10                for dr, dc in dirs:
11                    nr, nc = i+dr, j+ dc
12                    if inbound(nr, nc, m, n) and grid[nr][nc] == '1' and (nr, nc) not in visited:
13                        visited.add((nr, nc))
14                        queue.append((nr, nc))
15
16        m = len(grid)
17        n = len(grid[0])
18        visited = set()
19        queue = deque()
20        count = 0
21        for i in range(m):
22            for j in range(n):
23                if grid[i][j] == '1' and (i, j) not in visited:
24                    count += 1
25                    visited.add((i, j))
26                    queue.append((i,j))
27                    bfs()
28        return count
29
30
31