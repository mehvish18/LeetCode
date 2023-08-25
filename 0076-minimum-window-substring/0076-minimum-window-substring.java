class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int c = mp.size();
        int min = Integer.MAX_VALUE, j=0;
        String ans="";
        while(j<s.length() && mp.get(s.charAt(j))==null){
            j++;
        }
        for(int i=j;i<s.length();i++){
            char ch = s.charAt(i);
            if(mp.get(ch)!=null){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0){
                    c--;
                }
                
                while(mp.get(ch)<=0){
                    char cj = s.charAt(j);
                    if(mp.get(cj)!=null){
                        if(mp.get(cj)+1>0)
                            break;
                        mp.put(cj,mp.get(cj)+1);
                    }
                    j++;
                }
                
                if(c==0){
                        if((i-j+1)<min){
                            min = i-j+1;
                            ans = s.substring(j,i+1);
                        }
                }
            }  
        }
        return ans;
    }
}