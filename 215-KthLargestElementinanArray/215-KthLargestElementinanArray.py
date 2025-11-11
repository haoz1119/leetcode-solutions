# Last updated: 11/11/2025, 11:46:44 AM
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]
