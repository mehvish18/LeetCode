class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s=-1,e=-1;
        int l=0,h=nums.length-1;
        while(l<=h){
            int m = l +(h-l)/2;
            if(nums[m]<target){
                l=m+1;
            }
            else if(nums[m]>target){
                h=m-1;
            }
            else {
                s=m;
                h=m-1;   
            }
        }
        l=0;
        h=nums.length-1;
        while(l<=h){
            int m = l +(h-l)/2;
            if(nums[m]<target){
                l=m+1;
            }
            else if(nums[m]>target){
                h=m-1;
            }
            else {
                e=m;
                l=m+1; 
            }
        }
        int ans[] = new int[2];
        ans[0] = s;
        ans[1] = e;
        return ans;
    }
}