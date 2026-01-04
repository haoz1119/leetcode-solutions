# Last updated: 1/3/2026, 8:04:56 PM
1from collections import deque
2class Solution:
3    def numIslands(self, grid: List[List[str]]) -> int:
4        count = 0
5        queue = deque()
6        m = len(grid)
7        n = len(grid[0])
8        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
9
10        def inbound(r, c):
11            return 0 <= r < m and 0 <= c < n
12
13        for i in range(m):
14            for j in range(n):
15                if grid[i][j] == "1":
16                    grid[i][j] = 0
17                    queue.append((i, j))
18                    count += 1
19                    while queue:
20                        r, c = queue.popleft()
21                        for dr, dc in dirs:
22                            nr, nc = r + dr, c + dc
23                            if inbound(nr, nc) and grid[nr][nc] == "1":
24                                grid[nr][nc] = 0
25                                queue.append((nr, nc))
26        return count
27