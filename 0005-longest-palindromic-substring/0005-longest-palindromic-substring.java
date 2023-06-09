class Solution {
    public String longestPalindrome(String s) {
        String rev = "";
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            rev = rev + s.charAt(i);
        }
        int [][] dp = new int[n+1][n+1];
        int max = 0;
        int Idx=0, Jdx;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(max<dp[i][j] && i-dp[i][j]==n-j){
                        max=dp[i][j];
                        Idx=i;
                        Jdx=j;
                    }
                }
                else
                    dp[i][j]=0;
            }
        }
        return s.substring(Idx-max,Idx);
    }
}
/*
  0 1 2 3 4 5
0 0 0 0 0 0 0
1 0 0 0 1 0 1
2 0 0 1 0 2 0
3 0 0 0 2 0 3
4 0 0 0 0 3 0
5 0 0 0 0 0 0


babad
dabab





*/