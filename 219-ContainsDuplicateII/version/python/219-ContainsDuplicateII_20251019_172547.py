# Last updated: 10/19/2025, 5:25:47 PM
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        seen = defaultdict(int) 
        for i, n in enumerate(nums):
            if n in seen:
                j = seen.get(n)
                if i - j <= k:
                    return True
            seen[n]=i
        return False