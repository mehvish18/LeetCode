class Solution {
    public String minWindow(String s, String t) {
        String str="";
        if(t.length()>s.length())
            return str;
        int i=0,j=0,min=Integer.MAX_VALUE,lc=0;
        Map<Character,Integer> mp = new HashMap<>();
        for(i=0;i<t.length();i++){
            char ch = t.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        i=0;
        while(i<s.length() && mp.get(s.charAt(i))==null){
            j++;
            i++;
        }
        for(;i<s.length();i++){
            char ch = s.charAt(i);
            if(mp.get(ch)!=null){
                mp.put(ch,mp.get(ch)-1);
            
            if(mp.get(ch)==0){
                lc++;
            }
            while(mp.get(ch)<=0){
                char c = s.charAt(j);
                if(mp.get(c)!=null){
                    if(mp.get(c)+1>0){
                        break;
                    }
                    mp.put(c,mp.get(c)+1);  
                }
                j++;
                
            }
            }
            if(lc==mp.size()){
                if((i-j+1)<min){
                    min = i-j+1;
                    str = s.substring(j,i+1);
                }
            }    
        }
        return str;
    }
}

/*
s "aaaaaaaaaaaabbbbbcdd"
t "abcdd"
A:1
B:1
C:1
D:2
w= 4

w=1
A:0
B:1
C:1
D:2

i=1
j=1



*/