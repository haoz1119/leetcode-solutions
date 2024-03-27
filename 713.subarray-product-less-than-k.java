/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
// brute force approach  O(n^2)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int num = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] >= k) continue; 
            else{
                num++;
                int prod = nums[i];
                for(int j = i + 1; j < n; j++){
                    prod = prod * nums[j];
                    if(prod < k) num++;
                    else break;
                }
            }
        }
        return num;
    }
}

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int num = 0;
        int left = 0;
        int right = 0;
        int prod = nums[right];
        
        // If k is less than or equal to 1, no subarray can have a product less than k
        if(k <= 1) return 0;
        
        while(right < n){
            // If the product is less than k, all subarrays from left to right are valid
            if(prod < k) {
                num += right - left + 1; // Increment the count by the number of valid subarrays
                right++; // Expand the window to the right
                if(right >= n) break;
                prod = prod * nums[right]; // Update the product
            } else {
                // If the product is greater than or equal to k, shrink the window from the left
                prod = prod / nums[left]; // Remove the leftmost element from the product
                if(left == right){
                    left++; // Move both pointers to the right
                    right++;
                    if(right >= n) break;
                    prod = prod * nums[right]; // Update the product
                } else if(left < right){
                    left++; // Move the left pointer to the right
                }
            }
        }
        return num;
    }
} 
// @lc code=end

