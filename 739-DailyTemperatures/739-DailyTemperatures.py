# Last updated: 10/23/2025, 10:13:57 PM
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans = [0]*len(temperatures)
        stack = []
        for i, t in enumerate(temperatures):
            while stack and t > stack[-1][0]:
                temp, j = stack.pop()
                ans[j]=i-j
            stack.append((t,i))
        return ans