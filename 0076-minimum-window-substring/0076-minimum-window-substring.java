class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        int l = 0,r;
        int co=0;
        int min=Integer.MAX_VALUE;
        String w="",minS="";
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
           //System.out.println(r+" r "+c);
           if(mp.get(c)!=null){
               mp.put(c,mp.get(c)-1);
               //System.out.println("mp: "+mp.get(c));
               if(mp.get(c)==0){
                   co++;
                   //System.out.println("co: "+co);
               }
               while(mp.get(c)<=0){ //"AXABNBCY"
                   //System.out.println(l+" l "+s.charAt(l));
                   if(mp.get(s.charAt(l))!=null){ 
                    if((mp.get(s.charAt(l))+1)>0){
                        //System.out.println("hello "+mp.get(s.charAt(l)));
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