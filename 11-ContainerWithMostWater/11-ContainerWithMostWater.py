# Last updated: 9/14/2025, 12:55:13 PM
class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height)-1
        maxA = 0
        while left < right:
            n = right-left
            maxA = max(maxA, min(height[left], height[right])*n)
            if height[left] < height[right]:
                oldhl = height[left]
                while left < right and height[left]<=oldhl:
                    left+=1
            else:
                oldhr = height[right]
                while left < right and height[right]<=oldhr:
                    right-=1  
        return maxA