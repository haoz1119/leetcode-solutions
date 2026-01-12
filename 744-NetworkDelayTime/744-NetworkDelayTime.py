# Last updated: 1/12/2026, 12:23:28 AM
import math
from heapq import heappush, heappop
from typing import List
class Solution:
    def build_adj(self, times:List[List[int]], n: int) -> List[List[int]]:
        adj = [[] for i in range(n+1)]
        for u, v, t in times:
            adj[u].append((v, t))
        return adj
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = self.build_adj(times, n)
        time = [math.inf]*(n+1)
        time[k] = 0
        queue = []
        heappush(queue, (0, k))
        while queue:
            t, node = heappop(queue)
            if t > time[node]:
                continue
            for nei in adj[node]:
                cur_t = t + nei[1]
                if cur_t < time[nei[0]]:
                    time[nei[0]] = cur_t
                    heappush(queue, (cur_t, nei[0]))
        max_time = max(time[1:])
        return max_time if max_time != math.inf else -1
