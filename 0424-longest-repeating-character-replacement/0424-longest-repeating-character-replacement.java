class Solution {
    public int characterReplacement(String s, int k) {
       Map<Character,Integer> mp = new HashMap<>();
       int i=0,j=0,max=0;
       char maxChar;
       int mc=0;
       while(i<s.length()){
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            if(mp.get(ch)>mc){
                mc = mp.get(ch);
                maxChar = ch;
            }
            if(i-j+1-mc-k>0){
                mp.put(s.charAt(j),mp.get(s.charAt(j))-1);
                j++;
            }
            max = Math.max(max,(i-j+1));
            i++;
        }
        return max;
    }
}
/*
k=2

AA ABBC







*/