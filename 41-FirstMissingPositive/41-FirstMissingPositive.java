// Last updated: 9/14/2025, 12:54:35 PM
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains1 = false;
        for(int i = 0; i < n; i++){
            if(nums[i]==1) contains1 = true;
            if(nums[i] <= 0||nums[i] > n) nums[i] = 1;
        }
        if(!contains1) return 1;
        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            nums[a-1] = (-1)*Math.abs(nums[a-1]);
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) return i+1;
        }
        return n+1;
    } 
}