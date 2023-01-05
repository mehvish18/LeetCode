class Solution {
    Map<String,List<String>> adj = new HashMap<>();
    Map<String,Boolean> visited = new HashMap<>();
    public boolean checkDiff(String s1, String s2){
        int cnt=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1)
            return true;
        return false;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> nodes = new ArrayList<>();
        nodes.add(beginWord);
        nodes.addAll(wordList);
        for(String node: nodes){
            List<String> nList = adj.getOrDefault(node,new ArrayList<String>());
            for(String word: wordList){
                if(!node.equals(word)){
                    if(checkDiff(node,word)){
                        nList.add(word);
                        adj.put(node,nList);
                    }
                }
            }
        }
        /*for(String key: adj.keySet()){
            System.out.println(key+" "+adj.get(key));
        }*/
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.put(beginWord,true);
        Queue<Integer> c = new LinkedList<>();
        c.add(1);
        while(!q.isEmpty()){
            String u = q.poll();
            int cnt = c.poll();
            if(adj.get(u)!=null){
                for(String v: adj.get(u)){
                    if(visited.get(v)==null){
                        if(v.equals(endWord))
                            return cnt+1;
                        q.add(v);
                        c.add(cnt+1);
                        visited.put(v,true);
                    }
                }
            }
        }
        return 0;
    }
}