// Last updated: 9/14/2025, 12:54:23 PM
int maxProfit(int* prices, int pricesSize) {
    int prof = 0;
    int min = prices[0];
    for (int i = 0; i < pricesSize; i++) {
        if(prices[i]< min) min = prices[i];
        prof = prices[i]-min > prof ? prices[i]-min : prof;
    }
    return prof;
}