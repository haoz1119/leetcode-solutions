// Last updated: 9/14/2025, 12:54:20 PM
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