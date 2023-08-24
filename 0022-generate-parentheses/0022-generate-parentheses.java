class Solution {
    List<String> ans = new ArrayList<>();
    public void getParenthesis(Character ch, int openCount, int pairCount, String s){
        s += ch;
        if(pairCount==0){
            ans.add(s);
            return;
        }
        if(openCount<pairCount){
                getParenthesis('(',openCount+1,pairCount,s);
        }
        if(openCount>0){
                getParenthesis(')',openCount-1,pairCount-1,s);
        }
  
    }
    public List<String> generateParenthesis(int n) {
        getParenthesis('(',1,n,"");
        return ans;
    }
}






/*


   (,1,3
  /  \
(,2,3 ),0,3


*/