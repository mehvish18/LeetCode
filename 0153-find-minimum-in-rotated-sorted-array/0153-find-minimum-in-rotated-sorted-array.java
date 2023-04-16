class Solution {
    public int findMin(int[] nums) {
        int l=0,r = nums.length-1;
        if(nums[r]>nums[0])
            return nums[0];
        while(l<r){
            int m= l+(r-l)/2;
            if(nums[m]>nums[m+1])
                return nums[m+1];
            
            if(nums[m-1]>nums[m])
                return nums[m];
            
            if(nums[l]<nums[m])
                l=m+1;
            else
                r=m-1;
                
                
        }
        return nums[l];
    }
}


