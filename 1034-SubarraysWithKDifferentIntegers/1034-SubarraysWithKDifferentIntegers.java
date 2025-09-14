// Last updated: 9/14/2025, 12:53:19 PM
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
            set.put(nums[right], right);
            if(set.size() > k){
                int min = Integer.MAX_VALUE;
                for(int i : set.values()){
                    if(min > i) min = i;
                }
                set.remove(nums[min]);
                left = min + 1;
            }
            count += right - left + 1;
        }
        return count;
    }

}