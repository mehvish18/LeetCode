class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n =nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum%2!=0)
            return false;
        int target = sum/2;
        boolean [][]dp = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(j==0)
                    dp[i][j]= true;
                else if(i==0)
                    dp[i][j]= false;
                else if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else
                     dp[i][j] = dp[i-1][j];
                
            }
        }
        return dp[n][target];
    }
}