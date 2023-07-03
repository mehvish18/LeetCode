class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1)
            return 0;
        else if(n==2)
            return Math.max(0, prices[1]-prices[0]);
        
        int dp[][] = new int[n][2];
        dp[0][1] = -prices[0];
        dp[1][1]= Math.max(-prices[1], -prices[0]);
        dp[1][0] = Math.max(prices[1]-prices[0], 0);
        int max=0;
        for(int i=2;i<n;i++){
            dp[i][0] = Math.max(prices[i]+dp[i-1][1], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-2][0]-prices[i], dp[i-1][1]);
            int profit = Math.max(dp[i][0],dp[i][1]);
            max = Math.max(profit,max);
        }
        return max;
    }
}
