class Solution {
    public int findMin(int[] nums) {
        int l=0,r = nums.length-1;
        if(nums[l]<nums[r])
            return nums[l];
        while(l<r){
            int m= l+(r-l)/2;
            if(nums[m]>nums[r])
                l=m+1;
            else if(nums[m]<nums[r])
                r=m;
            else
                r--;
                
                
                
        }
        return nums[l];
    }
}


