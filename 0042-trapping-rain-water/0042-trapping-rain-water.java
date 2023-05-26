class Solution {
    public int trap(int[] height) {
       int l =0, h=height.length -1;
       int highestLowestHeight = 0;
       int area = 0;
       while(l<h){
           if(height[l]<height[h]){
               if(height[l]>highestLowestHeight){
                   area = area + ((height[l]-highestLowestHeight)*(h-l)) - height[l];
                   highestLowestHeight = height[l];
               }
               else{
                   area = area - height[l];
               }
               l++;
           }
           else {
               if(height[h]>highestLowestHeight){
                   area = area + ((height[h]-highestLowestHeight)*(h-l)) - height[h];
                   highestLowestHeight = height[h];
               }
               else{
                   area = area - height[h];
               }
               h--;
           }
       }
        return area;
    }
}




/*
0,1,0,2,1,0,1,3,2,1, 2, 1
0 1 2 3 4 5 6 7 8 9 10 11


l=7
h=7

hi = 3

a = (1-0)*(11-1)-1* -0 -1* + (2-1)*(10-3)-2* - 1 -0 - 1 - 2 -1-2 
a = 10 -1 -0 -1 + 7 - 2 -1 - 0 -1 -2 -1 -2  = 6


4,2,0,3,2,5
0,1,2,3,4,5


l=5 h=5

hi=4

a = (4-0)*(5-0) - 4 -2 - 0 - 3 - 2 = 9


*/


