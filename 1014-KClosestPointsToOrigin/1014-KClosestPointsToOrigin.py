# Last updated: 1/12/2026, 12:23:16 AM
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def distsq(x1: int, y1:int)->int:
            return x1*x1+y1*y1
        hp = []
        for x1, y1 in points:
            if len(hp) >= k:
                heapq.heappushpop(hp, (-distsq(x1, y1),[x1,y1]))
            else:
                heapq.heappush(hp, (-distsq(x1, y1),[x1,y1]))
        return [l for _, l in hp]