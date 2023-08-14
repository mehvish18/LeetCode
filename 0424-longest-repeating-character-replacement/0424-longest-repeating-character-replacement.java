class Solution {
    public int characterReplacement(String s, int k) {
        int j=0;
        Map<Character, Integer> mp = new HashMap<>();
        int mc=0, max=1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            if(mp.get(ch)>mc){
                mc = mp.get(ch);
            }
            while(i-j+1-mc-k>0){
                mp.put(s.charAt(j),mp.get(s.charAt(j))-1);
                j++;
            }
            if(max<i-j+1){
                max = i-j+1;
            }
        }
        return max;
        
    }
}


/*
AABABBA
0123456

mc = 3

A:2
B:3

k=1
5-3-1>0



*/