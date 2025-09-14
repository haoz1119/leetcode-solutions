// Last updated: 9/14/2025, 12:53:36 PM
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