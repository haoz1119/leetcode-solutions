# Last updated: 11/11/2025, 12:54:12 PM
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def distsq(x1: int, y1:int)->int:
            return x1*x1+y1*y1
        hp = []
        for x1, y1 in points:
            heapq.heappush(hp,(-distsq(x1, y1),[x1,y1]))
            if len(hp) > k:
                heapq.heappop(hp)
        return [l for _, l in hp]