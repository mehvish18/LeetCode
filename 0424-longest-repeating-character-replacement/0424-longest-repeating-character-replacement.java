class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,max=0,mostFreqLetter=0;
        int lettersChanged=0;
        int []freq = new int[26];
        for(r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            mostFreqLetter = Math.max(mostFreqLetter,freq[s.charAt(r)-'A']);
            lettersChanged = r-l+1-mostFreqLetter;
            if(lettersChanged>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            max = Math.max(max,(r-l+1));
        }
        return max;
    }
}