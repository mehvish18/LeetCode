class Solution {
    public int burstBal(int[] nums, int l, int r, int dp[][]){
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=0)
            return dp[l][r];
        for(int i=l;i<=r;i++){
            int coins = nums[i];
            if(l-1>=0)
                coins *= nums[l-1];
            if(r+1<nums.length)
                coins *= nums[r+1];
            coins += burstBal(nums,l,i-1,dp) + burstBal(nums,i+1,r,dp);
            dp[l][r]=Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        return burstBal(nums,0,n-1,dp);
    }
        
}

/*

3158

1*3*1 + 158

3 + 3*1*5 +58

31 + 1*5*8 +8

315 + 5*8*1






*/