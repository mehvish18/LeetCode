class Solution {
    public int countSubstrings(String s) {
        int count=0;
        int l=0,r=0;
        int le=0, re=0;
        for(int mid=0;mid<s.length();mid++){
            l = mid-1; 
            r = mid+1;
            le = mid;
            re = mid+1;
            int currCount =1;
            int eveCount =0;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                currCount++;
            }
            while(le>=0 && re<s.length() && s.charAt(le)==s.charAt(re)){
                le--;
                re++;
                eveCount++;
            }
            
            count = count+currCount+eveCount;
        }
        return count;
    }
}

/*
     b. a  c. b  b
 [0, 0, 0, 0, 0, 0]
b[0, 1, 0, 0, 1, 1]
b[0, 1, 0, 0, 1, 2]
c[0, 0, 0, 1, 0, 0]
a[0, 0, 1, 0, 0, 0]
b[0, 1, 0, 0, 1, 1]

*/
