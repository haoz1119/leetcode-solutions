/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
// it is giving greedy so i tried
/*
greedy will become clear if you draw a graph for the stock price                                          
*/
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i-1]<prices[i]){
                profit += prices[i] - prices[i-1];
            }
            
        }
        return profit;
    }
}

 
// a more understandable solution
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++; // stops when the price is not decreasing anymore
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++; // stops when the price is not increasing anymore
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
// @lc code=end

