# Last updated: 11/6/2025, 4:47:50 PM
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if len(nums) == 0: return []
        if len(nums) == 1: return [f"{nums[0]}"]
        out = []
        for i in range(len(nums)):
            if not out or out[-1][1]!=nums[i]-1:
                out.append([nums[i],nums[i]])
            elif out[-1][1]==nums[i]-1:
                out[-1][1] = nums[i]

        for i, r in enumerate(out):
            s,e = r
            if s != e:
                out[i]=f"{s}->{e}"
            else:
                out[i]=f"{s}"
        return out