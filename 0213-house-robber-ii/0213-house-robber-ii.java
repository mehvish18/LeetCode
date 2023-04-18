class Solution {
    public int getdp(int[] nums, int strt ,int end){
        int n= end-strt+1;
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=nums[strt];
        dp[2]=Math.max(nums[strt],nums[strt+1]);
        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-2]+nums[strt+i-1],dp[i-1]);
        }
        return dp[n];
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        if(nums.length==1)
            return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int n= getdp(nums,0,nums.length-2);
        int m= getdp(nums,1,nums.length-1);
        
        return Math.max(n,m);
    }
}
