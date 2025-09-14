// Last updated: 9/14/2025, 12:53:05 PM
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int f = 0;
        int max = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i]>max) max =nums[i];
        }
        for(int i = 0; i < n; i++){
            if(nums[i]==max) f++;
        }
        if(f<k) return 0;
        f = 0;
        long count = 0;
        for(int left = 0, right = 0; right < n; right++){
            if(nums[right]==max) f++;
            while(f == k){
                if(nums[left++]==max){
                    f--;
                }
            }
            count+=left;
        }
        return count;
    }
}