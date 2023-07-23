class Solution {
    int dp[][];
    public int noOfDistinctChars(String s, String t, int sIdx, int tIdx){
        if(dp[sIdx][tIdx]!=-1)
            return dp[sIdx][tIdx];
        if(tIdx>=t.length())
            return 1;
        if(sIdx>=s.length())
            return 0;
        if(t.charAt(tIdx)==s.charAt(sIdx))
           dp[sIdx][tIdx] = noOfDistinctChars(s,t,sIdx+1,tIdx+1) + noOfDistinctChars(s,t, sIdx+1,tIdx);
        else 
           dp[sIdx][tIdx] = noOfDistinctChars(s,t, sIdx+1,tIdx);;
        return dp[sIdx][tIdx];
          
    }
    public int numDistinct(String s, String t) {
        dp = new int[s.length()+1][t.length()+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return noOfDistinctChars(s,t,0,0);
    }
}