# Last updated: 11/6/2025, 5:10:33 PM
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if not nums: return []
        out = []
        start = end = nums[0]
        for num in nums[1:]:
            if num == end + 1:
                end = num
            else:
                out.append(f"{start}->{end}" if start != end else f"{start}")
                start = end = num
        out.append(f"{start}->{end}" if start != end else f"{start}")
        return out