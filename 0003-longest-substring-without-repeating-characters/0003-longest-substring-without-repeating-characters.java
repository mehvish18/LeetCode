class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        String w="";
        int i=0,j=0,max=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            //System.out.println("i "+i+" "+s.charAt(i)+" "+mp.get(s.charAt(i)));
            while(mp.get(ch)>1){
                mp.put(s.charAt(j),mp.get(s.charAt(j))-1);
                //System.out.println("j "+j+" "+s.charAt(j)+" "+mp.get(s.charAt(j)));
                j++;
            }
            int count = i-j+1;
            //System.out.println("count "+count);
            max = Math.max(max,count);
            i++;
            
        }
        return max;
    }
    
}
