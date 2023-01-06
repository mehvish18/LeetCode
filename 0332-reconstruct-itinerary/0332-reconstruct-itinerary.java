class Solution {
    HashMap<String,PriorityQueue<String>>adj=new HashMap<>();
    // HashMap<String,Integer>in=new HashMap<>();
    // HashMap<String,Integer>out=new HashMap<>();
    List<String>ans=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String>s:tickets){
            String a=s.get(0);
            String b=s.get(1);
            if(!adj.containsKey(a))
                adj.put(a,new PriorityQueue<String>());
            adj.get(a).add(b);
            //We always strt with JFK so we dont need in and out degree
          //  out.put(a,out.getOrDefault(a,0)+1);
            // if(!in.containsKey(a))
            //     in.put(a,0);
            // in.put(b,in.getOrDefault(b,0)+1);
            // if(!out.containsKey(b))
            //     out.put(b,0);
        }
        // String start="";
        // for(String x:adj.keySet()){
        //     if(out.get(x)-in.get(x)==1)
        //         {
        //             start=x;
        //             break;
        //         }
        // }
       dfs("JFK");
       Collections.reverse(ans);
       return ans;
        
    }
     void dfs(String node){
     
        if(adj.containsKey(node)){
            while(adj.get(node).size()>0){
              PriorityQueue<String>a=adj.get(node);
                //int n=a.size();
                String x=a.poll();
                // a.remove(n-1);
                dfs(x);
             
            }
            
        }

        ans.add(node);


        return;
    }
}