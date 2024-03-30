/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithAtMostKDistinct(nums, k)-subarrayWithAtMostKDistinct(nums, k-1);
    }

    int subarrayWithAtMostKDistinct(int[] nums, int k){
        HashMap<Integer, Integer> set = new HashMap<>();
        int dist = 0;
        int n = nums.length;
        int count = 0;
        for(int left = 0, right = 0; right < n; right++){
            if(!set.containsKey(nums[right])){
                dist++;
            }
            set.put(nums[right], 1 + set.getOrDefault(nums[right], 0));
            while(dist > k){
                int f = set.get(nums[left]);
                if(f > 1) set.put(nums[left], f-1);
                else set.remove(nums[left]);
                if(f < 2) dist--;
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

}
// @lc code=end

