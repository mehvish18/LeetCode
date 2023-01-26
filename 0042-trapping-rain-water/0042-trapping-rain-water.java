class Solution {
    public int trap(int[] height) {
        int left=0, right=height.length-1;
        int leftbar = height[left], rightbar=height[right];
        int rain = 0;
        while(left < right){
            if(leftbar<rightbar){
                if(height[left]>leftbar)
                    leftbar = height[left];
                else{
                    rain += leftbar - height[left];
                    left++;
                }
            }
            else{
                if(height[right]>rightbar)
                    rightbar = height[right];
                else{
                    rain += rightbar - height[right];
                    right--;
                }
            }
        }
        return rain;
    }
}