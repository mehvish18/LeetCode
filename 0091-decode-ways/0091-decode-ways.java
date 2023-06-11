class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==1){
            if(s.equals("0"))
                return 0;
            return 1;
        }
        Map<String,Character> mp = new HashMap<>();
        for(int i=65;i<=90;i++){
            int ch = i-64;
            mp.put(""+ch,(char)i);
        }
        int dp[] = new int[n];
        if(s.charAt(0)=='0')
            dp[0]=0;
        else
            dp[0]=1;
        String str = s.substring(0,2);
        int digit = Integer.parseInt(str);
        if(mp.get(str)!=null){
            dp[1]=2;
            if(digit==10||digit==20)
                dp[1]=1;
                
        }
        else if(digit>26 && s.charAt(1)!='0')
            dp[1]=1;
        else
            dp[1]=0;
        for(int i=2;i<n;i++){
            str = s.substring(i-1,i+1);
            if(mp.get(str)!=null){
                if(str.equals("10")||str.equals("20")){
                    dp[i] = dp[i-2];
                }
                else{
                    dp[i] = dp[i-2]+dp[i-1];
                }      
            }
            else if(mp.get(s.substring(i,i+1))!=null){
                dp[i] = dp[i-1];
            }
            
        }
        return dp[n-1];
    }
}