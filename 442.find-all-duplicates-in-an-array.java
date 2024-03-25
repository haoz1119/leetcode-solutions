/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
// The tricky part is not noticing that the range is [1, n]
// this tells you that you can use an array instead of HashSet
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] num = new int[nums.length+1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(num[nums[i]]>0) list.add(nums[i]);
            else num[nums[i]]++;
        }
        return list;
    }
}
// @lc code=end

