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

// shorter but the same approach
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Handle edge cases where k is 0 or 1 (no subarrays possible)
        if (k <= 1) return 0;

        int totalCount = 0;
        int product = 1;

        // Use two pointers to maintain a sliding window
        for (int left = 0, right = 0; right < nums.length; right++) {
            // Expand the window by including the element at the right pointer
            product *= nums[right];

            // Shrink the window from the left while the product is greater than or equal to k
            while (product >= k) {
                // Remove the element at the left pointer from the product
                product /= nums[left++];
            }

            // Update the total count by adding the number of valid subarrays with the current window size
            totalCount += right - left + 1;  // right - left + 1 represents the current window size
        }

        return totalCount;
    }
}
// @lc code=end

