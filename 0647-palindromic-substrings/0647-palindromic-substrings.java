class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        int count=0;
        for(int k=0;k<n;k++){
            dp[k][k] = 1;
            count++;
        }
        for(int k=0;k<n-1;k++){
            if(s.charAt(k)==s.charAt(k+1)){
                dp[k][k+1] = 1;
                count++;                                           
            }
        }
        for(int k=3;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                int j = i+k-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j] = 1;
                    count++;                                          
                }
            }
        }
        return count;
    }
}