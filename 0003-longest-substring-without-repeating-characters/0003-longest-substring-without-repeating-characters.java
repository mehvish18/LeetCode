class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;
        int strt=0;
        Map<Character,Integer> charCount = new HashMap<>();
        int max=1;
        for(int end=0;end<s.length();end++){
            char ch = s.charAt(end);
            charCount.put(ch,charCount.getOrDefault(ch,0)+1);
            while(charCount.get(ch)>1){
                charCount.put(s.charAt(strt),charCount.get(s.charAt(strt))-1);
                strt++;
            }
            int len = end - strt +1;
            if(max<len)
                max = len;
        }
        return max;
    }
}