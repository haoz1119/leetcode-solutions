# Last updated: 12/16/2025, 3:17:12 PM
1import math
2from heapq import heappush, heappop
3from typing import List
4class Solution:
5    def build_adj(self, times:List[List[int]], n: int) -> List[List[int]]:
6        adj = [[] for i in range(n+1)]
7        for u, v, t in times:
8            adj[u].append((v, t))
9        return adj
10    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
11        adj = self.build_adj(times, n)
12        time = [math.inf]*(n+1)
13        time[k] = 0
14        queue = []
15        heappush(queue, (0, k))
16        while queue:
17            t, node = heappop(queue)
18            if t > time[node]:
19                continue
20            for nei in adj[node]:
21                cur_t = t + nei[1]
22                if cur_t < time[nei[0]]:
23                    time[nei[0]] = cur_t
24                    heappush(queue, (cur_t, nei[0]))
25        max_time = max(time[1:])
26        return max_time if max_time != math.inf else -1
27