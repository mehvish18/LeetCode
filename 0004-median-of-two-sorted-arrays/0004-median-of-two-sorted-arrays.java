class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a;
        int[] b;
        if(nums2.length<nums1.length){
            a = nums2;
            b = nums1;
        }
        else {
            a = nums1;
            b = nums2;
        }
        int n1 = a.length;
        int n2 = b.length;
        int n = n1+n2;
        int half = (n+1)/2;
        int l=0, r=n1;
        double median=0 ;
        while(l<=r){
            int i = l + (r-l)/2;
            int j = half - i;
            //System.out.println(l+" "+r+" "+i+" "+j);
            int aleft, aright, bleft, bright;
            if(i>0)
                aleft = a[i-1];
            else
                aleft = Integer.MIN_VALUE;
 
            if(i<n1)
                aright = a[i];
            else
                aright = Integer.MAX_VALUE;
            
            if(j>0)
                bleft = b[j-1];
            else
                bleft = Integer.MIN_VALUE;
 
            if(j<n2)
                bright = b[j];
            else
                bright = Integer.MAX_VALUE;
            
            //System.out.println(aleft+" "+aright+" "+bleft+" "+bright);
            
            if(aleft<=bright && bleft<=aright){
                if(n%2==0){
                    median = (Math.max(aleft,bleft)+Math.min(aright,bright))/2.0;
                }
                else
                    median = Math.max(aleft,bleft);
                return median;
            }
            else if(aleft>bright){
                r = i-1;
            }
            else {
                l = i+1;
            }
            
        }
        return -1;
    }
}
