class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int area = 0;
        int currMin = 0;
        while(l<r){
            area = area - Math.min(currMin,Math.min(height[l],height[r]));
            if(currMin<Math.min(height[l],height[r])){ 
                area = area +(Math.min(height[l],height[r]) - currMin)*(r-l-1);
                currMin = Math.min(height[l],height[r]);  
            }
            if(height[l]<=height[r])
                l++;
            else
                r--;
           
        }
        return area;
        
    }
}




/*
0,1,0,2,1,0,1,3,2,1, 2, 1
0 1 2 3 4 5 6 7 8 9 10 11



0+9-0-0-1+6-1-1-0-1-2-1-2 = 9-9+6 = 6
*/
