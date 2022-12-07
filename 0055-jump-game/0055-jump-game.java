class Solution {
    public boolean canJump(int[] nums) {

       int lastidx = nums.length - 1;
       for(int i=lastidx-1;i>=0;i--){
           if(i+nums[i]>=lastidx)
               lastidx=i;
       }
        return lastidx==0;
    }
}