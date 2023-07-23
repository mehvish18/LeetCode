class Solution {
    int dp[][];
    int m,n;
    public int minOperation(String word1, String word2, int idx1, int idx2){
        //System.out.println(idx1+" "+idx2+" called");
        if(idx2>=n) {
            //System.out.println(idx1+" "+idx2+" returned "+ (m-idx1));
            return m-idx1;
        }
        if(idx1>=m){
            //System.out.println(idx1+" "+idx2+" returned "+ (n-idx2));
            return n-idx2;
        }
        if(dp[idx1][idx2]!=-1) {
            //System.out.println(idx1+" "+idx2+" returned "+ dp[idx1][idx2]);
            return dp[idx1][idx2];
        }
        if(word1.charAt(idx1)==word2.charAt(idx2))
            dp[idx1][idx2] = minOperation(word1,word2,idx1+1, idx2+1);
        else
            dp[idx1][idx2] = 1 + Math.min(minOperation(word1, word2, idx1, idx2+1),Math.min(minOperation(word1, word2, idx1+1, idx2), minOperation(word1, word2, idx1+1, idx2+1)));
        //System.out.println(idx1+" "+idx2+" returned "+ dp[idx1][idx2]);
        return dp[idx1][idx2];  
    }
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return minOperation(word1, word2, 0,0); 
    }
}

/*

0 1 2 3
p a r k

0 1 2 3 4
s p a k e








*/