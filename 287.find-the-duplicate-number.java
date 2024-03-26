/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
// we can use a hash array to solve it or
// like the approach below
// we flip the sign of the element at index 
// once we read a number is that index
// if when we read that element at the index
// again, meaning we get the same index again
// that number will be negative
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            if(nums[a]<0) return a;
            nums[a] = (-1)*nums[a];
        }
        return 0;
    }
}
// @lc code=end

