class Solution {
public int findTargetSumWays(int[] nums, int target) {
        int s1, n = nums.length, total = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        if((total-target)%2==1 || target>total)
            return 0;
        s1 = (total-target)/2;
        int dp[][] = new int[n+1][s1+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s1;j++){
                if(j==0)
                    dp[i][j]=1;
                if(i==0)
                    continue;
                else if(nums[i-1]<=j)
                    dp[i][j]=dp[i-1][j-nums[i-1]] + dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
       }
       return dp[n][s1];
    }
}