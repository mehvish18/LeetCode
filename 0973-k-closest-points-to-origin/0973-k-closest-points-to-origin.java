class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                double d1 = Math.sqrt(Math.pow(p1[0],2)+Math.pow(p1[1],2));
                double d2 = Math.sqrt(Math.pow(p2[0],2)+Math.pow(p2[1],2));
                if(d1==d2)
                    return 0;
                else if(d1<d2)
                    return -1;
                return 1;
            }
        });
        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
        }
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
}