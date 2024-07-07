/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1; // the 0th element always counts, i is the insertion index
        for(int j = 1; j < nums.length; j++){
            // how did we ensure that the new found element is unique from all previous elements?
            // it says the nums is non decreasing, meaning if some elements
            // are non unique, all duplicate values will be one after the other, 
            // it will not appear out of order
            if(nums[j] != nums[i-1]){ // nums[i-1] will be the last unique element
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
// @lc code=end

