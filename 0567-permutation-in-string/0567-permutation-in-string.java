class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        Map<Character,Integer> mp = new HashMap<>();
        int k=s1.length(),co=0;
        for(int i=0;i<s1.length();i++){
            mp.put(s1.charAt(i),mp.getOrDefault(s1.charAt(i),0)+1);
        }
        int l=0;
        for(int i=0;i<k;i++){
            char c = s2.charAt(i);
            if(mp.get(c)!=null){    
                mp.put(c,mp.get(c)-1);
                if(mp.get(c)==0)
                    co++;
            }
        }
        if(co==mp.size())
            return true;
        for(int i=k;i<s2.length();i++){
            char c = s2.charAt(i);
            if(mp.get(s2.charAt(i-k))!=null){
                if(mp.get(s2.charAt(i-k))==0)
                    co--;
                mp.put(s2.charAt(i-k),mp.get(s2.charAt(i-k))+1);
            }
            if(mp.get(c)!=null){ 
                mp.put(c,mp.get(c)-1);
                if(mp.get(c)==0)
                    co++;
            }
            if(co==mp.size())
                return true;
        }
        return false;
    }
}