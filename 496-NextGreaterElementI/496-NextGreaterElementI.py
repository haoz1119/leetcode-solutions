# Last updated: 10/23/2025, 9:08:58 PM
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = [-1]*len(nums1)
        minstack = [] # monotonic decreasing
        ng = {} # next greater, value to index pair
        for i, n in enumerate(nums2):
            if not minstack:
                minstack.append(i)
            elif nums2[minstack[-1]] > n:
                minstack.append(i)
            else:
                while minstack and nums2[minstack[-1]] < n:
                    j = minstack.pop()
                    ng[nums2[j]] = n
                minstack.append(i)
        for i, n in enumerate(nums1):
            if n in ng:
                ans[i] = ng[n]
        return ans




