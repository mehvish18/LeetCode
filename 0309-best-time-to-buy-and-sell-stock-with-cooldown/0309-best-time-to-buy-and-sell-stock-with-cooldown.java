class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <2 ) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(prices[1] - prices[0], 0);
        }
        int profit = 0;
        int[][] dp = new int[prices.length][2];
        //dp[i][0]: no share at hand at the end of day i
        //dp[i][1]: has share at the end of day i
        dp[0][1]  = -prices[0];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        
        for (int i=2; i<= prices.length-1; i++) { //len >= 3
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);//3 days to complete a transaction
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            profit = Math.max(profit, Math.max(dp[i][0], dp[i][1]));
        }
        return profit;
    }
}