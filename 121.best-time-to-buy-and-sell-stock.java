/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int p : prices){
            if(p - minPrice > maxProfit){
                maxProfit = p - minPrice;
            }
            if(p < minPrice){
                minPrice = p;
            }
        } 
        return maxProfit;
    }
}
// @lc code=end

