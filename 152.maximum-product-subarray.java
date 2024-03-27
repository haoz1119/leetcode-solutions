/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
/**
 * if the array does not have 0, then the maximum product must start from the leftmost element or the rightmost element
 * 1. if the array has one negative, then the maximum product must start from the leftmost zero or the rightmost zero
 * if the array has two negatives, then the maximum product is the entire array
 * if the array has odd number of negatives, 1 would still apply
 * if the array has even number of negatives, then the maximum product is the entire array
 * if the array does have zeros, then we can split the array in to several subarrays without zeros, That's to say, when the prefix product is 0, we start over and compute prefix product from the current element instead. 
 * zero acts like a divider.
 */
class Solution {
    public int maxProduct(int[] A) {
        int n = A.length, res = A[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}
// @lc code=end

