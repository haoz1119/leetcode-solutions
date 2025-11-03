# Last updated: 11/2/2025, 9:35:08 PM
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        while l < r:
            mid = (l+r)//2
            hr = sum([math.ceil(x/mid) for x in piles])
            if hr > h:
                l = mid +1
            else:
                r = mid
        return l

