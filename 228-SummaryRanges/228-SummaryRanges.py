# Last updated: 11/6/2025, 5:05:44 PM
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if len(nums) == 0: return []
        if len(nums) == 1: return [f"{nums[0]}"]
        out = []
        end = nums[0]
        start = end
        for i in nums[1:]:
            if i == end + 1 :
                end = i
            else:
                if start == end: 
                    out.append(f"{start}")
                else:
                    out.append(f"{start}->{end}")  
                start = i
                end = i

        out.append(f"{end}" if end == start else f"{start}->{end}")
        return out