class Solution {
    public int trap(int[] height) {
        int l=0, h = height.length-1;
        int addWater=0,subtractWater=0;
        int level = 0,currlevel=0;
        while(l<h){
            int currLevel = Math.min(height[l],height[h]);
            if(currLevel<=level){
                subtractWater += Math.min(level,currLevel);
            }
            else{
                addWater += (currLevel-level) * (h-l-1);
                if(level!=0)
                    subtractWater += Math.min(level,currLevel);
                level = currLevel;
            }
            if(height[l]<height[h]){
                l++;
            }
            else{
                h--;
            }
        }
        return addWater-subtractWater;
    }
}