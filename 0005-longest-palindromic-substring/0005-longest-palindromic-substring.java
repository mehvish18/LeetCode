class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        int max=1, idx=0;
        for(int k=0;k<n;k++){
            dp[k][k] = 1;
        }
        for(int k=0;k<n-1;k++){
            if(s.charAt(k)==s.charAt(k+1)){
                dp[k][k+1] = 1;
                max=2;
                idx=k;                                            
            }
        }
        for(int k=3;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                int j = i+k-1;
                if(i>j)
                    continue;
                    
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j] = 1;
                    if(k>max){
                        max=k;
                        idx=i;                                            
                    }
                }
            }
        }
        return s.substring(idx,idx+max);
    }
}

/*

k=3
i=0, j = 2

i=1, j=3


cbbd
0123


  0 1 2 3
0 1 0 0 0
1   1 1 0
2     1 0
3       1




*/