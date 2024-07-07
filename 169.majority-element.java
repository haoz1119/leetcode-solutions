/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
// optimal solution
// Boyer-Moore Voting Algorithm:
// if the majority element is in the prefix, it will also be the majority element in the suffix(since the number of majority element in the prefix is the same as the number of other elements in the prefix) 
// if the majority element is not in the prefix, it will still be the majority element in the suffix
class Solution {
    public int majorityElement(int[] nums) {
        int can = 0;
        int fre = 0;
        for(int num : nums){
            if(fre == 0){
                can = num;
                fre++;
            }
            else {
                if(num == can){
                    fre++;
                }else fre--;
            }
        }
        return can;
    }
}

// not so optimal solution
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
// @lc code=end

