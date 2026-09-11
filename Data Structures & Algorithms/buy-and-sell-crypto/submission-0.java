class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int buyPrice = prices[0];
        for(int i=1;i<n;i++) {
            int currPrice = prices[i];
            if(currPrice>buyPrice) {
                maxProfit = Math.max(currPrice-buyPrice, maxProfit);
            } else {
                buyPrice = currPrice;
            }
        }
        return maxProfit;
    }
}
