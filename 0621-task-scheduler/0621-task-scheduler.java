class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0)
            return tasks.length;
        int ans=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a1,int[] a2){
                return a2[1]-a1[1];
            }
        });
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            mp.put((int)tasks[i],mp.getOrDefault((int)tasks[i],0)+1);
        }
        for(int a: mp.keySet()){
            int [] pqEle = new int[2];
            pqEle[0] = a;
            pqEle[1] = mp.get(a);
            pq.add(pqEle);
        }
        int time=0;
        while(pq.size()>0){
            int pqEle[] = pq.poll();
            if(pqEle!=null)
                time++;
            if(pq.size()==0 && pqEle[1]-1==0)
                break;
            List<int[]> lst = new ArrayList<>();
            for(int i=0;i<n;i++){
                int [] ElementsLeftToSelect = pq.poll();
                lst.add(ElementsLeftToSelect);
                time++;
                if(pq.size()==0 && pqEle[1]-1==0)
                        break; 
            }
            if(pqEle[1]>1){
                pqEle[1]=pqEle[1]-1; 
                pq.add(pqEle);
            }
            for(int[] ele : lst){
                if(ele!=null) {
                        if(ele[1]>1){
                            ele[1]=ele[1]-1; 
                            pq.add(ele);
                        }
                }
            }
        }
        return time;
        
    }
}



