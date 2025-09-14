# Last updated: 9/14/2025, 12:54:14 PM
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set(nums)
        l = 0
        longest = 0
        for num in s:
            if num-1 not in s:
                l = 1
                while num+1 in s:
                    num += 1
                    l += 1
                longest = max(longest, l)
        return longest
        