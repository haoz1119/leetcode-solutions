/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
// brute force solution
class Solution {
    public void rotate(int[] nums, int k) {
        int last = 0;
        for(int i = 0; i < k; i++){
            last = nums[nums.length - 1];
            for(int j = nums.length - 1; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }
}
// a better solution but using O(n) space
// extra space solution
// but easy to understand
class Solution {
    public void rotate(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for(int i = 0; i < nums.length; i++){
            nums[(i+k)% nums.length] = copy[i];
        }
    }
}

// a better solution using O(1) space
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // if k > nums.length
        int count = 0;  // count the number of elements that have been moved
        for (int start = 0; count < nums.length; start++) { // we stop when all elements have been moved
            int current = start; // current position
            int prev = nums[start]; // previous element
            do {
                int next = (current + k) % nums.length; // next position
                int temp = nums[next]; // store the next element
                nums[next] = prev; // move the previous element to the next position
                prev = temp; // update the previous element with the next element
                current = next; // update the current position
                count++;    // increase the count
            } while (start != current); // stop when we return to the start position
            // there could be situations where we return to the start position before all elements have been moved, when n % k == 0(for example, 6 % 2 == 0)
        }
    }
}
// @lc code=end

