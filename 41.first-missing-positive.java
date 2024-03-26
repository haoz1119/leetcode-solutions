/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
// the easy way but need O(n) axilary space apprach is to 
// hava a boolean array from 1 to n.
// also you need to realize that the range for positive integers
// in an array if we are looking for the smallest missing 
// integer should be 1 to n
// and if 1, 2, .., n all included, the smallest missing integer should be 
// n+1
// to achieve O(1) space, we need to use sign and current 
// array, negative with index means the index exists in the 
// array, positive with index means the index does not exist
// in the array
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains1 = false;
        for(int i = 0; i < n; i++){
            if(nums[i]==1) contains1 = true;
            if(nums[i] <= 0||nums[i] > n) nums[i] = 1;
        }
        if(!contains1) return 1;
        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            nums[a-1] = (-1)*Math.abs(nums[a-1]);
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) return i+1;
        }
        return n+1;
    } 
}
// @lc code=end

