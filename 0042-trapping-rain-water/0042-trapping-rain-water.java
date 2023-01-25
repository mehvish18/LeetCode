class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int ans=0;
        int lastH=0;
        boolean left=true;
        int c=0;
        while(l<r){
            int hgt = Math.min(height[r],height[l]);
            int width = r-l-1;
            //System.out.println("l: "+l+" r"+r);
            
            if(c>0){
                int h;
                if(left)
                    h=Math.min(height[l],lastH);
                else
                    h=Math.min(height[r],lastH);
                //System.out.println(h);
                ans = ans-h;
                
            }
            if(hgt>lastH){
                ans = ans+(hgt-lastH)*width;
                lastH = hgt;
                c++;//System.out.println("c: "+c);
                
            }
            if(height[l]<height[r]){
                left=true;
                l++;
            }
            else {
                left=false;
                r--;
            }
        }
        return ans;
    }
}