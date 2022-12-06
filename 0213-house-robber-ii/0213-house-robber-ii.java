class Solution {

    public int profit(int [] nums, int start,int end){
        //System.out.println(start+" "+end);
        int [] dp = new int[nums.length];
        dp[start]= nums[start];
        dp[start+1]= Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[end];
    }
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int a = profit(nums,0,nums.length-2);
        int b = profit(nums,1,nums.length-1);
        return Math.max(a,b);
    }
}