// Last updated: 9/14/2025, 12:54:00 PM
class Solution {
    public int majorityElement(int[] nums) {
        int can = 0;
        int count = 0;
        for(int n : nums){
            if(count == 0){
                can = n;
                count = 1;
            }
            else if(can == n){
                count++;
            }else{
                count--;
            }
        }
        return can;
    }
}