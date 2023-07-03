class Solution {
    public String longestPalindrome(String s) {
        String rev = "";
        int n = s.length();
    
        int max = 1, idx=1;
        String ans = "";
        for(int i=n-1;i>=0;i--)
            rev += s.charAt(i);
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j] = 1 +dp[i-1][j-1];
                    if(dp[i][j]>max && (i-dp[i][j] == n-j)){
                        max = dp[i][j];
                        idx = i;
                    }
                }
                else
                    dp[i][j]=0;
                    
            }
        }
        ans = s.substring(idx-max,idx);
        return ans;
    }
}

/*

babad
01234

dabab
01234


  0 1 2 3 4 5 
0 0 0 0 0 0 0 
1 0 0 0 1 0 1 
2 0 0 1 0 1 0 
3 0
4 0
5 0

The dp[][] array is a 2-dimensional matrix where each cell dp[i][j] represents the length of the longest common substring ending at index i in the first string and index j in the second string.
*/