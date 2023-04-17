class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0){
            return tasks.length;
        }
        HashMap<Character, Integer> map=new HashMap<>();
        for(char x: tasks) map.put(x, map.getOrDefault(x, 0)+1);
        PriorityQueue<Map.Entry<Character, Integer>> pq =new PriorityQueue<Map.Entry<Character, Integer>>((e1, e2) -> e2.getValue()-e1.getValue());
        pq.addAll(map.entrySet());
        PriorityQueue<Map.Entry<Character, Integer>> q =new PriorityQueue<Map.Entry<Character, Integer>>((e1, e2) -> e2.getValue()-e1.getValue());
        int res=0;
        while(!pq.isEmpty()){
            for(int i=0; i<=n; i++){
                if(!pq.isEmpty()){
                    Map.Entry<Character, Integer> entry = pq.poll();
                    entry.setValue(entry.getValue() - 1);
                    if(entry.getValue()!=0){
                        q.add(entry);
                    }
                    res++;
                   // System.out.println("a");
                }else if(!q.isEmpty()){
                    res++;
                    //System.out.println("b");
                }else{
                    break;
                }
            }
            while(!q.isEmpty()){
                Map.Entry<Character, Integer> entry = q.poll();
                pq.add(entry);
            }
        }
        return res;
    }
}


