# Last updated: 12/31/2025, 2:30:39 PM
1class Solution:
2    def rob(self, nums: List[int]) -> int:
3        n = len(nums)
4        dp = [0] * n
5        dp[0] = nums[0]
6        if n < 2:
7            return dp[0]
8        dp[1] = max(nums[0], nums[1])
9        for i in range(2, len(nums)):
10            dp[i] = max(nums[i]+dp[i-2], dp[i-1]) # max of either we rob house i and the best we got up to i-2, or we dont rob house i and it is the best we got up to house i-1
11        
12        return dp[n-1]