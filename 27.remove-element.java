/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
// What it is doing is essentially whenever we find a valid element, we put it in the front, and i is also used to track the number of valid elements.

// How do we know when we overwrite element at index i, we are not overwriting an element that is valid but we have not looked at? We can be sure of that because we know j is always greater or equal to i, so that when we are overwriting i, we know if at index i, the element is valid, it has been placed in the front already.


class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
// @lc code=end

