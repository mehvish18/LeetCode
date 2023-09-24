class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        else if(n==2)
            return Math.max(nums[0],nums[1]);
        int dp [] = new int[n];
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp[2]=nums[0]+nums[2];
        int max=Math.max(dp[1],dp[2]);
        for(int i=3;i<n;i++){
            dp[i] = Math.max(dp[i-2],dp[i-3])+nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}


/*
1,2,3,1

2 7 9 3 1
2 7 11 10 12


5 3 8  10 1

5 3 13 15 14

*/