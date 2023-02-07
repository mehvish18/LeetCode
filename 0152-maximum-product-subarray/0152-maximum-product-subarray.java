class Solution {
    public int maxProduct(int[] nums) {
        int l=0;
        int prod=1,max=Integer.MIN_VALUE;
        int negativecount = 0;
        for(int r=0;r<nums.length;r++){
            prod=prod*nums[r];
            max = Math.max(max,prod);
            if(nums[r]==0)
                prod=1;
        }
        prod=1;
        for(int r=nums.length-1;r>0;r--){
            prod=prod*nums[r];
            max = Math.max(max,prod);
            if(nums[r]==0)
                prod=1;
        }
        return max;
    }
}