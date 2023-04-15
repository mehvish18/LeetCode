class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l=1, r = (int)Math.pow(10,9);
        int min=r,m=0;
        while(l<=r){
            m = l+(r-l)/2;
            long hours =0;
            for(int i=0;i<piles.length;i++){
                double d = (double)piles[i]/m;
                hours = hours + (int)Math.ceil(d);
            }
            if(hours>h){
                l=m+1; 
            }
            else {
                if(hours<=h){   
                    r = m-1;
                }
            }
        }
        return l;
    }
}