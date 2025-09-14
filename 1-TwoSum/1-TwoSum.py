# Last updated: 9/14/2025, 12:55:16 PM
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        visited = dict()
        for i, num in enumerate(nums):
            if target - num in visited:
                return [i, visited[target-num]]
            visited[num] = i
        return []