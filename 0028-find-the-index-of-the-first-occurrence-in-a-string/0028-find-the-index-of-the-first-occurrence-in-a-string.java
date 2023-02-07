class Solution {
    public int strStr(String haystack, String needle) {
        int k = needle.length();
        if(k>haystack.length())
            return -1;
        for(int i=0;i<=haystack.length()-k;i++){
            String s1 = haystack.substring(i,i+k);
            if(s1.equalsIgnoreCase(needle)){
                return i;
            }
        }
        return -1;
    }
}