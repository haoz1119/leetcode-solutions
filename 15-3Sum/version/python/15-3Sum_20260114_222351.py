# Last updated: 1/14/2026, 10:23:51 PM
1class Solution:
2    def threeSum(self, nums: List[int]) -> List[List[int]]:
3        nums.sort()
4        if nums[0]>0:
5            return []
6        n = len(nums)
7        res = []
8        for i in range(n):
9            n1 = nums[i]
10            if i > 0 and n1 == nums[i-1]:
11                continue
12            if n1 > 0: break
13            l, r = i+1, n-1
14            while l < r:
15                ln, rn = nums[l], nums[r]
16                if ln + rn == -n1:
17                    res.append([n1, ln, rn])
18                    while l+1 < n and nums[l+1] == ln:
19                        l += 1
20                    l += 1
21                elif ln + rn < -n1:
22                    l += 1
23                else:
24                    r -= 1
25        return res