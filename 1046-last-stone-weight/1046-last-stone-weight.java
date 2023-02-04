class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
                int y = pq.poll();
                int x = pq.poll();
                System.out.println(y+" x "+x);
                if(y!=x){
                    System.out.println(y-x);
                    pq.add(y-x);
                }
    
        }
        System.out.println(pq.size());
        if(pq.size()==0)
            return 0;
        return pq.peek();
    }
}


    