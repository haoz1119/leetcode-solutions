# Last updated: 1/10/2026, 12:34:06 AM
1class Solution:
2    def topKFrequent(self, arr: List[int], k: int) -> List[int]:
3        count = Counter(arr)
4        hp = []
5        for key, value in count.items():
6            heapq.heappush(hp, (value, key))
7            if len(hp) > k:
8                heapq.heappop(hp) 
9        return [key for _, key in hp]
10