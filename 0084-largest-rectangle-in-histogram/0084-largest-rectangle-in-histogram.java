class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stck = new Stack<>();
        int [] ele = {-1,0};
        stck.push(ele);
        int max = 0;
        
        for(int i=0;i<heights.length;i++){
            int right=i;
            int left=i;
            while(stck.peek()[1]>heights[i]){
                int l = stck.peek()[0];
                int width = (right-l);
                int area = stck.peek()[1]*width;
                if(max<area){
                    max = area;
                }
                left = l;
                stck.pop();
            }
            ele = new int[2];
            ele[0]=left;
            ele[1]=heights[i];
            stck.push(ele);
        }
        while(!stck.isEmpty()){
          ele = stck.pop();
          int index = ele[0];
          int h = ele[1];
          max = Math.max(max, h * (heights.length-index));
        }
        return max;
    }
}

/*

-1 , 0
0, 2
0, 4
*/