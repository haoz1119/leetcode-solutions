# Last updated: 10/24/2025, 9:08:53 PM
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        s = 0 # sum
        count = {} # count of prefix sum seen so far
        count[0] = 1
        ans = 0
        for n in nums:
            s += n
            if s-k in count:
                ans+=count[s-k]
            count[s] = count.get(s, 0)+1
        return ans
            

