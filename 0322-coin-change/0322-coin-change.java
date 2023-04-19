class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            for(int j=0;j<amount+1;j++){
                if(i==0 && j!=0)
                    dp[i][j] = Integer.MAX_VALUE-1;
                else if(j==0)
                    dp[i][j] = 0;
                else if(i==1){
                    if(j%coins[i-1]==0)
                        dp[i][j]=j/coins[i-1];
                    else
                        dp[i][j] = Integer.MAX_VALUE-1;
                }
                else if(coins[i-1]==j)
                    dp[i][j]=1;
                else if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[coins.length][amount]==Integer.MAX_VALUE-1)
            return -1;
        return dp[coins.length][amount];
    }
}