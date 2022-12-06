class Solution {
    public boolean canJump(int[] nums) {
        boolean [] dp = new boolean[nums.length];
        dp[0]=true;
        for(int i=0; i<=nums.length-2; i++){
            for(int j=1;j<=nums[i];j++){
                if(i+j<nums.length)
                    dp[i+j] = dp[i];
            }
        }
        return dp[nums.length-1];
    }
}