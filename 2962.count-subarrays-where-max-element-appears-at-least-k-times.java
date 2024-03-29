/*
 * @lc app=leetcode id=2962 lang=java
 *
 * [2962] Count Subarrays Where Max Element Appears at Least K Times
 */

// @lc code=start
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = 0;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }
        long ans = 0;
        int start = 0, frequency = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                frequency++;
            }
            while (k == frequency) {
                // start will be one ahead of the leftmost maxElement after frequency is met
                // and frequency will decrease by 1 to k-1
                // start only goes to the next leftmost maxElement when we found a new one
                if (nums[start] == maxElement) {
                    frequency--;
                }
                start++;
            }
            ans += start;
        }

        return ans;
    }
}
// @lc code=end

