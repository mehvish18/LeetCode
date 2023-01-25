class Solution {
    public int maxArea(int[] height) {
        int l=0,h=height.length-1;
        int maxArea=0;
        while(l<h){
            int area = (h-l)*Math.min(height[l],height[h]);
            if(area>maxArea)
                maxArea=area;
            if(height[l]<height[h])
                l++;
            else 
                h--;
        }
        return maxArea;
    }
}