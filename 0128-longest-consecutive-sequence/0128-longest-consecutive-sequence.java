class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    Map<Integer,Boolean> visited = new HashMap<>();
    public int bfs(int source){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited.put(source,true);
        int len = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i);
                if(visited.get(v)==null){
                    visited.put(v,true);
                    q.add(v);
                    len++;
                }
            }
        }
        return len;
    }
    public int longestConsecutive(int[] nums) {
        int max =0;
        for(int i=0;i<nums.length;i++){
            adj.put(nums[i], new ArrayList<>());
        }
        for(int i=0;i<nums.length;i++){
            if(adj.get(nums[i]-1)!=null) {
                List<Integer> l1 = adj.get(nums[i]);
                l1.add(nums[i]-1);
                adj.put(nums[i],l1);
                l1 = adj.get(nums[i]-1);
                l1.add(nums[i]);
                adj.put(nums[i]-1,l1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(visited.get(nums[i])==null){
                max = Math.max(max,bfs(nums[i]));
            }
        }
        return max;
    }
}

//len = 1


/*
0:
3:2
7:6,8
2:3
5:4
8:7
4:5
6:7
0:
1:
*/

    
