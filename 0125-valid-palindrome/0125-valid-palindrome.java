class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i=0;i<s.length();i++){
            int n = (int)s.charAt(i);
            //System.out.println(n);
            if((n>=65 && n<=90) || (n>=97 && n<=122) || (n>=48 && n<=57))
                str =str+s.charAt(i);
        }
        char [] ch = str.toLowerCase().toCharArray();
        int l=0, r=ch.length-1;
        while(l<=r){
            //System.out.println(ch[l]+" "+ch[r]);
            if(ch[l]==ch[r]){
                l++;
                r--;
            }
            else
                return false;
        }
        return true;
    }
}