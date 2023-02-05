class Solution {
    class CharCount{
        public char ch;
        public int count;
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> mp = new HashMap<>();
        PriorityQueue<CharCount> pq = new PriorityQueue<>(new Comparator<CharCount>(){
            public int compare(CharCount c1, CharCount c2) {
                if(c1.count==c2.count)
                    return 0;
                else if(c1.count<c2.count)
                    return 1;
                else
                    return -1;
                    
            }
        });
        for(int i=0;i<tasks.length;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }
        for (Map.Entry<Character,Integer> entry : mp.entrySet()){
            CharCount chp = new CharCount();
            chp.ch = entry.getKey();
            chp.count = entry.getValue();
            pq.add(chp);
        }
        int time=0;
        while(pq.size()>0){
            CharCount chp = pq.poll();
            if(chp!=null) {
                //System.out.println(chp.ch +" "+chp.count);
                time++;
            }
            if(pq.size()==0 && chp.count-1==0)
                break;
            //System.out.println("time: "+time);
            List<CharCount> cc = new ArrayList<>();
            for(int i=0;i<n;i++){
                    CharCount cpk = pq.poll();
                    cc.add(cpk);
                    time++;
                    //System.out.println("innr time: "+time);
                    if(pq.size()==0 && chp.count-1==0)
                        break;
            }
            if(chp.count>1){
                chp.count--; 
                pq.add(chp);
            }
            for(CharCount cpk : cc){
                if(cpk!=null) {
                        //System.out.println("innr "+cpk.ch+" "+cpk.count);
                        if(cpk.count>1){
                            cpk.count--; 
                            pq.add(cpk);
                        }
                }
            }
            
        }
        return time;
    }
}

