class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        Map<Character,Integer> count = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ci = s1.charAt(i);
            char cj = s2.charAt(i);
            count.put(ci,count.getOrDefault(ci,0)+1);
            count.put(cj,count.getOrDefault(cj,0)-1);
        }
        if(checkZeros(count))
            return true;
        for(int i=s1.length();i<s2.length();i++){
            char ci = s2.charAt(i-s1.length());
            char cj = s2.charAt(i);
            count.put(cj,count.getOrDefault(cj,0)-1);
            count.put(ci,count.get(ci)+1);
            if(checkZeros(count))
                return true;
        }
        
        return false;
    }
    public boolean checkZeros(Map<Character,Integer> count){
        for(Map.Entry<Character, Integer> entry : count.entrySet()){
            if(entry.getValue()!=0)
                return false;
        }
        return true;
    }
}
