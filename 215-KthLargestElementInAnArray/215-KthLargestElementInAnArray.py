# Last updated: 9/14/2025, 12:53:50 PM
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        mh = []
        for x in nums:
            heapq.heappush(mh, x)
        return heapq.nlargest(k, mh)[-1]