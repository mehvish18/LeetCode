class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        LinkedList<Integer> q = new LinkedList<>();
        int [] inDegree = new int [numCourses];
        for(int i=0;i<numCourses;i++){
            for(int j=0;j<adj.get(i).size();j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int cnt =0;
        while(q.size()>0){
            int u = q.poll();
            cnt++;
            for(int v:adj.get(u)){
                if(--inDegree[v]==0){
                    q.add(v);
                }
            }
        }
        if(cnt==numCourses)
            return true;
        return false;
        
        
    }
}
