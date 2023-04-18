class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        if(((int)s.charAt(0)-48)>0 && ((int)s.charAt(0)-48)<27)
            dp[1]=1;
        
        if(n==1)
            return dp[1];
        
        dp[2]=0;
        int ch = Integer.parseInt(s.charAt(0)+""+s.charAt(1));
        //System.out.println(ch);
        if(ch<=9)
            dp[2]=0;
        else if(ch>9 && ch<27){
            if(ch==10 || ch==20){
                dp[2]=1;
            }
            else
                dp[2]=2;
        }else if(((int)s.charAt(1)-48)>0){
            dp[2]=1;
        }
            
        for(int i=3;i<=n;i++){
            ch = (int)s.charAt(i-1)-48;
            int ch1 = Integer.parseInt(s.charAt(i-2)+""+s.charAt(i-1));
            //System.out.println(ch+" "+ch1);
            dp[i]=0;
            if(ch>0)
                dp[i] = dp[i] + dp[i-1];
            if(ch1>9 && ch1<27)
                dp[i] = dp[i] + dp[i-2];
        }   
            
        return dp[n];
    }
}
