class Solution {
    public String longestPalindrome(String s) {
        String s2="";
        int n=s.length();
        int dp[][]=new int [n+1][n+1];
        int max=0;
        String ans = "";
        for(int i=n-1;i>=0;i--){
            s2 = s2+s.charAt(i);
        }
        for(int i=0;i<=n;i++) {
            dp[i][0]=0;
            dp[0][i]=0;
        }
        int iIdx = 0;
        int jIdx = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                        if(max<dp[i][j]){
                            if(i-dp[i][j]==n-j)
                            {
                                max=dp[i][j];
                                iIdx = i;
                                jIdx = j;
                            }
                    }
                    
                }
                else 
                    dp[i][j]=0;
                
            }
        }
        
        while(iIdx>=1 && jIdx>=1 && dp[iIdx][jIdx]>0){
            ans += s.charAt(iIdx-1);
            iIdx--;
            jIdx--;
        }
        return ans;
        
    }
}