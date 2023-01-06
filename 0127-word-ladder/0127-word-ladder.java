class Solution {
    public int binaryBfs(Set<String> begin, Set<String> end, Set<String> dictionary, int level){
        if(begin.size()==0||end.size()==0)
            return 0;
        level++;
        dictionary.removeAll(begin);
        Set<String> newSet = new HashSet<>();
        for(String s:begin){
            char [] oldword = s.toCharArray();
            for(int i=0;i<oldword.length;i++){
                char oldchar = oldword[i];
                for(char c='a';c<='z';c++){
                    oldword[i]=c;
                    String newWord = new String(oldword);
                    if(!dictionary.contains(newWord))
                        continue;
                    if(end.contains(newWord))
                        return level;
                    newSet.add(newWord);
                }
                oldword[i]=oldchar;
            }
        }
        return (newSet.size()>end.size())?binaryBfs(end,newSet,dictionary,level):binaryBfs(newSet,end,dictionary,level);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        
        Set<String> end = new HashSet<>();
        end.add(endWord);
        
        Set<String> dictionary = new HashSet<>(wordList);
        return binaryBfs(begin,end,dictionary,1);
    }
}