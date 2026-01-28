# Last updated: 1/27/2026, 7:13:46 PM
1class Solution:
2    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
3        if len(nums1) > len(nums2):
4            nums1, nums2 = nums2, nums1
5        m = len(nums1) # 3 234
6        n = len(nums2) # 4 2345
7        half = (m+n+1)//2 # mid 3
8        l, r = 0, m
9        while l <= r:
10            mid = (l+r)//2 # 1
11            mid2 = half-mid #2
12            left1 = nums1[mid-1] if mid-1>=0 else float('-inf') #0
13            left2 = nums2[mid2-1] if mid2-1>=0 else float('-inf') #1
14            right1 = nums1[mid] if mid<m else float('inf') #2
15            right2 = nums2[mid2] if mid2<n else float('inf')#3
16            if left1 <= right2 and left2<= right1:
17                if (m+n)%2 == 1:
18                    return max(left1,left2)
19                return (max(left1, left2)+min(right1, right2))/2
20            elif left1>right2:
21                r = mid -1
22            else:
23                l = mid + 1
24