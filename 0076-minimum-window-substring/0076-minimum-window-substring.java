class Solution {
    public String minWindow(String s, String t) {
        int l = 0,r;
        int co=0;
        int min=Integer.MAX_VALUE;
        String minS="";
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }
        for(r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(mp.get(c)!=null){
                    l=r;
                    break;
            }
        }
        for(;r<s.length();r++){
           char c = s.charAt(r);
           if(mp.get(c)!=null){
               mp.put(c,mp.get(c)-1);
               if(mp.get(c)==0){
                   co++;
               }
               while(mp.get(c)<=0){ 
                   if(mp.get(s.charAt(l))!=null){ 
                    if((mp.get(s.charAt(l))+1)>0){
                        break;
                    }
                    mp.put(s.charAt(l),mp.get(s.charAt(l))+1);
                   }
                   l++;
               }
           }
           int d = co;
           
           if(co==mp.size()){
               if(min>(r-l+1)){
                   min=r-l+1;
                   minS=s.substring(l,r+1);
               }
           }
           
        }
        return minS;
    }
}