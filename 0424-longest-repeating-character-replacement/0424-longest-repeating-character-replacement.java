class Solution {
    public int characterReplacement(String s, int k) {
       Map<Character,Integer> mp = new HashMap<>();
       int i=0,j=0,max=0;
       int mc=0;
       while(i<s.length()){
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            if(mp.get(ch)>mc){
                mc = mp.get(ch);
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