# Last updated: 9/14/2025, 12:54:26 PM
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        k = m-1
        j = n-1
        p = m+n-1
        while k >= 0 and j >= 0:
            if nums1[k]<nums2[j]:
                nums1[p]=nums2[j]
                j-=1
                p-=1
            else:
                nums1[p]=nums1[k]
                k-=1
                p-=1
        if k >= 0:
            return
        if j >= 0:
            while j >= 0:
                nums1[p]=nums2[j]
                p-=1
                j-=1
