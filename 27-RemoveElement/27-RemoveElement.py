# Last updated: 9/14/2025, 12:55:52 PM
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        k = 0 # index of insertion
        for num in nums:
            if num == val:
                continue
            else:
                nums[k] = num
                k += 1
        return k