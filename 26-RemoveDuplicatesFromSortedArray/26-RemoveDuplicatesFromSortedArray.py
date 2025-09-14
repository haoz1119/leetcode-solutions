# Last updated: 9/14/2025, 12:55:53 PM
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        ue = nums[0]
        a = nums
        #front = 0
        k = 1 # number of unique element
        for i, num in enumerate(nums[1:]):
            if num != ue:
                ue = num
                nums[k] = num
                k += 1

            else:
                continue
        return k 