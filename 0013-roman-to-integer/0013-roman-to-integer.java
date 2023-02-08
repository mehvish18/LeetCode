class Solution {
    Map<Character,Integer> roman = new HashMap<>();
    public Solution(){
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
    }
    public int romanToInt(String s) {
        int ans = 0;
        for(int i=0;i<s.length();){
            Character c = s.charAt(i);
            int val = roman.get(c);
            if(i<s.length()-1 && val<roman.get(s.charAt(i+1))){
                ans = ans + roman.get(s.charAt(i+1)) - val;
                i= i+2;
            }
            else {
                ans = ans+val;
                i++;
            }
        }
        return ans;
    }
}

