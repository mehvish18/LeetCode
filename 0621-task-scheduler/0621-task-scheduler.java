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
        int i=0;
        while(pq.size()>0){
            //System.out.println(" pq"+pq.size());
            int pqEle[] = pq.poll();
            //System.out.println(Arrays.toString(pqEle));
            if(index.get(pqEle[0])==null || (i-index.get(pqEle[0])>n)){
                index.put(pqEle[0],i);
                pqEle[1]=pqEle[1]-1;
                if(pqEle[1]>0)
                    pq.add(pqEle);
            }
            else if(i-index.get(pqEle[0])<=n){ 
                List<int[]> lst = new ArrayList<>();
                while(index.get(pqEle[0])!=null && i-index.get(pqEle[0])<=n){
                    //System.out.println(pqEle[0]+" "+index.get(pqEle[0]));
                    lst.add(pqEle);
                    if(pq.peek()==null)
                        break;
                    pqEle = pq.poll();
                }
                for(int j=0;j<lst.size();j++){
                    pq.add(lst.get(j));
                } 
                if(index.get(pqEle[0])==null || i-index.get(pqEle[0])>n){
                    index.put(pqEle[0],i);
                    pqEle[1]=pqEle[1]-1;
                    if(pqEle[1]>0)
                        pq.add(pqEle);
                }
            }
            i++;
        }
        return i;
        
    }
}


/*
"A","A","A","B","B","B" n=2


A:0,2
B:0,2

A B idle A B idle A B




["A","A","A","A","A","A","B","C","D","E","F","G"]
n=2


A: 4
D: 1
E: 1
F: 1
G: 1

A i=3
B

A B C A

A:0 B:1 C:2



A B C A D E A F G A id id A id id A



*/