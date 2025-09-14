// Last updated: 9/14/2025, 12:53:43 PM
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            if(nums[a]<0) return a;
            nums[a] = (-1)*nums[a];
        }
        return 0;
    }
}