class Solution {
    public int maxArea(int[] height) {
        int maxArea =0, area =0;
        int i = 0, j= height.length-1;
        while(i<j){
            if(height[i]<height[j]){
                area = height[i]*(j-i);
                i++;
            }
            else{
                area = height[j]*(j-i);
                j--;
            }
            if(area>maxArea)
                maxArea=area;
                
        }
        return maxArea;
    }
}