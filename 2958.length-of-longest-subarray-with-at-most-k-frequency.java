/*
 * @lc app=leetcode id=2958 lang=java
 *
 * [2958] Length of Longest Subarray With at Most K Frequency
 */

// @lc code=start
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maxL = 0;
        for(int left = 0, right = 0; right < n; right++){
            int a = nums[right];
            map.put(a, 1 + map.getOrDefault(a, 0));
            int fa = map.get(a);
            while(fa > k){
                int l = nums[left];
                map.put(l, map.get(l) - 1);
                fa = map.get(a);
                left++;
            }
            int cur_max = right - left + 1;
            maxL = Math.max(cur_max, maxL);
        }
        return maxL;
    }
}
// @lc code=end

