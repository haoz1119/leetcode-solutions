# Last updated: 12/16/2025, 4:33:07 PM
1import math
2from heapq import heappush, heappop
3class Solution:
4    def minimumEffortPath(self, heights: List[List[int]]) -> int:
5        m = len(heights)
6        n = len(heights[0])
7        def inbound(r, c): # check if the neighbors inbound
8            return (0<=r<m) and (0<=c<n)
9        dirs = [(1,0),(-1,0),(0,1),(0, -1)] # all four directions 
10        dist = [[math.inf]*n for i in range(m)]
11        dist[0][0] = 0
12        queue = []
13        heappush(queue, (0, (0,0)))
14        while queue:
15            cur_dis, (r, c) = heappop(queue)
16            if cur_dis > dist[r][c]:
17                continue
18            for dr, dc in dirs:
19                nr = r+dr
20                nc = c+dc
21                if inbound(nr, nc):
22                    new_dis = max(cur_dis, abs(heights[r][c]-heights[nr][nc]))
23                    if new_dis < dist[nr][nc]:
24                        dist[nr][nc] = new_dis
25                        heappush(queue, (new_dis, (nr, nc)))
26
27        return dist[m-1][n-1]