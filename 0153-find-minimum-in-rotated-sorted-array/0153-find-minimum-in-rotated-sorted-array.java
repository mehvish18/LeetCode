class Solution {
    public int findMin(int[] nums) {
        int l=0, h = nums.length-1;
        if(nums[l]<nums[h])
            return nums[0];
        
        while(l<h){
            int mid = l + (h-l)/2;
            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            else if(nums[mid-1]>nums[mid])
                return nums[mid];
            
            if(nums[l]<nums[mid]){
                l=mid+1;
            }
            else
                h = mid-1;
        }
        return nums[l];
        
    }
}
