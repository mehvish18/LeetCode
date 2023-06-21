class Solution {
    public String longestPalindrome(String s) {
        String rev = "";
        int max = 0;
        int idx = 0;
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            rev = rev + s.charAt(i);
        }
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            dp[i][0]=0;
            dp[0][i]=0;
        }
        
        for(int i=1; i<=n;i++){
            for(int j=1; j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(i-dp[i][j]== n-j){
                        if(dp[i][j]>max){
                            max = dp[i][j];
                            idx = i;
                        }
                    }
                }
            }
        }
        return s.substring(idx-max,idx);
    }
}

/*
babad
01234

dabab
01234

n-1-i + dp [i][j] = j


  0 1 2 3 4 5
0 0 0 0 0 0 0
1 0 0 0 1 0.1
2 0 0  
3 0  
4 0
5 0       

cbbd




*/