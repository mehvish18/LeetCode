class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int i=0;
        int maxLen = 0;
        Character ch;
        for(int j=0;j<s.length();j++){
            Character c = s.charAt(j);
            mp.put(c,mp.getOrDefault(c,0)+1);
            while(mp.get(c)>1){
                ch = s.charAt(i);
                mp.put(ch,mp.get(ch)-1);
                i++;
            }
            
            maxLen = Math.max((j-i+1),maxLen);
        }
        return maxLen;
    }
}