// Last updated: 9/14/2025, 12:53:59 PM
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++){
            int first = start;
            int prev = nums[start];
            do{
                // use two pointers 
                int next = (start + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                start = (start + k) % nums.length;
                count++;
            }while(start != first);
            
        }
    }
}