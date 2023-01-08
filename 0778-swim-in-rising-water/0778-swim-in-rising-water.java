class Solution {
    public int swimInWater(int[][] g) {
        int m = g.length, n = g[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return g[p1[0]][p1[1]]-g[p2[0]][p2[1]];
            }
        });
        int[][] seen = new int[m][n];
        pq.add(new int[]{0,0});
        int max = g[0][0];
        while(true){
            int[] t = pq.remove();
            if(seen[t[0]][t[1]] == 1) continue;
            seen[t[0]][t[1]] = 1;
            max = Math.max(max, g[t[0]][t[1]]);
            if(t[0] == m-1 && t[1] == n-1) break;
            for(int[] child : children(g, t[0], t[1]))
                pq.add(child);
        }
        return max;
    }
    private List<int[]> children(int[][] g, int i, int j){
        int m = g.length, n = g[0].length;
        List<int[]> list = new ArrayList<>();
        if(i+1 < m)
            list.add(new int[]{i+1, j});
        if(i-1 >= 0)
            list.add(new int[]{i-1, j});
        if(j+1 < n)
            list.add(new int[]{i, j+1});
        if(j-1 >= 0)
            list.add(new int[]{i, j-1});
        return list;
    }
}