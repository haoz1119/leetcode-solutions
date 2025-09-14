# Last updated: 9/14/2025, 12:54:01 PM
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i = 0
        j = len(numbers)-1
        while i < j:
            if numbers[i] + numbers[j] == target:
                return [i+1, j+1]
            elif numbers[i]+numbers[j]< target:
                i+=1
            else:
                j-=1