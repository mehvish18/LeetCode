class Solution {
    
   public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1]=1;
        if(s.charAt(n-1)=='0')
            dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='0')
                dp[i]=0;
            else if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)-'0'<=6 && s.charAt(i+1)-'0'>=0))
                dp[i]=dp[i+1]+dp[i+2];
            else
                dp[i] = dp[i+1];
        }
        
    
        return dp[0];
    }
}