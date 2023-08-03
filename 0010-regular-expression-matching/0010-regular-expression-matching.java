class Solution {
    int n, m;
    int dp[][];
    public int regexMatch(String s, String p, int i, int j){
        //System.out.println(i+" "+j);
        if(i<1 && j<1){
            //System.out.println(i+" "+j+" "+1);
            return 1;
        }
        else if(j<1||i<0){
            //System.out.println(i+" "+j+" "+0);
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i>=1 && s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'){
            dp[i][j]=regexMatch(s, p, i-1, j-1);
            //System.out.println("hh");
        }
        else if(p.charAt(j-1)=='*'){
            if(p.charAt(j-2)=='.' || (i>=1 && p.charAt(j-2)==s.charAt(i-1))){
                dp[i][j] = regexMatch(s, p, i-1, j) + regexMatch(s, p, i-1, j-2) + regexMatch(s, p, i, j-2);
                //System.out.println("ff");
            }
            else{
                dp[i][j] = regexMatch(s, p, i, j-2);
                //System.out.println("dd");
            }
        } 
        else
            dp[i][j] = 0;
        //System.out.println(i+" "+j+" "+dp[i][j]);
        return dp[i][j];
    }
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int val = regexMatch(s, p, n, m);
        if(val==0)
            return false;
        return true;
    }
}