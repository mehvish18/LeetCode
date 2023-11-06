class Solution {
    public int[] findOrder(int numCourses, int[][] preq) {
        List<List<Integer>> adj = new ArrayList<>();
        int [] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            List<Integer> lst = new ArrayList<>();
            adj.add(lst);
        }
        for(int i=0;i<preq.length;i++){
                adj.get(preq[i][1]).add(preq[i][0]);
                indegree[preq[i][0]]++;
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        int []  ans = new int[numCourses];
        int cnt=0;
        while(q.size()>0){
            int u = q.poll();
            ans[cnt]=u;
            cnt++;
            for(int ele : adj.get(u)){
                if(--indegree[ele]==0){
                    q.add(ele);
                }
            }
        }
        if(cnt==numCourses)
            return ans;
        return new int[0];
    }
}