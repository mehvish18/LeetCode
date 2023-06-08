class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int [][] dp = new int [n][n];
        int max = 0, iIdx=0, jIdx=0;
        for(int i=0;i<n;i++){
            dp[i][i] = 1;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                iIdx=i;
                jIdx=i+1;
                max=2;
                dp[i][i+1] = 1;
            }
        }
        for(int k=3;k<=n;k++){
             for (int i = 0; i < n-k+1; i++){
                 int j = i + k - 1;
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1]==1) {
                        dp[i][j] = 1;
                        if((j-i+1)>max){
                            max=(j-i+1);
                            iIdx = i;
                            jIdx = j;
                        }
                    }
                }
            }
        }
        return s.substring(iIdx,jIdx+1);
        
    }
}

/*



*/