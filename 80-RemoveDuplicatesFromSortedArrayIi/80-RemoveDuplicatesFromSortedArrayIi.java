// Last updated: 9/14/2025, 12:54:27 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int i = 1; // index of insertion
        int flag = 1; // number of times we have seen it 
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i-1]) { // we find a unique element, nums[i-1] is the last unique element
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