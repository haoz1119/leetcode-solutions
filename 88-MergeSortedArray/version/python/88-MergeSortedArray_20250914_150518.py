# Last updated: 9/14/2025, 3:05:18 PM
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i, j = m-1, n-1
        k = m+n-1
        while i >=0 and j >= 0:
            if nums2[j] >= nums1[i]:
                nums1[k] = nums2[j]
                j-=1
            else:
                nums1[k] = nums1[i]
                i-=1
            k-=1
        if j >= 0:
            while k >= 0:
                nums1[k] = nums2[j]
                k-=1
                j-=1
        
