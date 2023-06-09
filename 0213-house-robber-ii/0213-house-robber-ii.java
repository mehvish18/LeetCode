class Solution {
    public int constructDpTable(int [] nums, int start, int end, int n){
        int dp[] = new int[n-1];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        int c=2;
        for(int i=start+2;i<end;i++){
            dp[c] = Math.max(nums[i]+dp[c-2],dp[c-1]);
            c++;
        }
        return dp[n-2];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        else if(n==2)
            return Math.max(nums[0],nums[1]);
        int val1 = constructDpTable(nums, 0, n-1, n);
        int val2 = constructDpTable(nums, 1, n, n);
        return Math.max(val1,val2);
        
    }
}

/*
[1,2,3]

n=3 

0 1
1 2 

0 1 2
2 3


*/