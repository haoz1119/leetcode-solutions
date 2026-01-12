# Last updated: 1/12/2026, 12:23:19 AM
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        while l < r:
            mid = (l+r)//2
            hr = sum(math.ceil(x/mid) for x in piles)
            if hr > h:
                l = mid +1
            else:
                r = mid
        return l

