# Last updated: 1/12/2026, 12:23:07 AM
import math
from heapq import heappush, heappop
class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m = len(heights)
        n = len(heights[0])
        def inbound(r, c): # check if the neighbors inbound
            return (0<=r<m) and (0<=c<n)
        dirs = [(1,0),(-1,0),(0,1),(0, -1)] # all four directions 
        dist = [[math.inf]*n for i in range(m)]
        dist[0][0] = 0
        queue = []
        heappush(queue, (0, (0,0)))
        while queue:
            cur_dis, (r, c) = heappop(queue)
            if cur_dis > dist[r][c]:
                continue
            for dr, dc in dirs:
                nr = r+dr
                nc = c+dc
                if inbound(nr, nc):
                    new_dis = max(cur_dis, abs(heights[r][c]-heights[nr][nc]))
                    if new_dis < dist[nr][nc]:
                        dist[nr][nc] = new_dis
                        heappush(queue, (new_dis, (nr, nc)))

        return dist[m-1][n-1]