/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
// used a hashmap to keep track of the number of times an element has appeared
class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int k = 1;
        int i = 1; // index of insertion
        map.put(nums[0], 1);
        for(int j = 1; j < nums.length; j++){
            if(!map.containsKey(nums[j])) {
                map.put(nums[j], 1);
                nums[i] = nums[j];
                i++;
                k++;
            }else if(map.containsKey(nums[j]) && map.get(nums[j]) < 2){
                map.put(nums[j], 2);
                nums[i] = nums[j];
                i++;
                k++;
            }
        }
        return k;
    }
}

// used a flag to keep track of the number of times an element has appeared with less space
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int i = 1; // index of insertion
        int flag = 1; // number of times we have seen it 
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i-1]) { // we find a unique element
                flag = 1;
                nums[i] = nums[j];
                i++;
                k++;
            }else if(flag < 2){ // we saw it a second time
                flag = 2;
                nums[i] = nums[j];
                i++;
                k++;
            }
        }
        return k;
    }
}
// @lc code=end

