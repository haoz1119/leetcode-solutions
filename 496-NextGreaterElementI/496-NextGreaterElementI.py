# Last updated: 10/23/2025, 9:14:01 PM
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = [-1]*len(nums1)
        minstack = [] # monotonic decreasing
        ng = {} # next greater, value to index pair
        for n in nums2:
            if not minstack:
                minstack.append(n)
            elif minstack[-1] > n:
                minstack.append(n)
            else:
                while minstack and minstack[-1] < n:
                    j = minstack.pop()
                    ng[j] = n
                minstack.append(n)
        for i, n in enumerate(nums1):
            if n in ng:
                ans[i] = ng[n]
        return ans




