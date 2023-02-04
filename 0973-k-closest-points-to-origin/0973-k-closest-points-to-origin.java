class Solution {
    class Point{
        public int x;
        public int y;
        public double val;

    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Point> pq = new PriorityQueue<Point>(1, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if(p1.val==p2.val)
                    return 0;
                else if(p1.val<p2.val)
                    return -1;
                else
                    return 1;
                    
            }
        });
        for(int i=0;i<points.length;i++){
            double d = Math.sqrt(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            Point p = new Point();
            p.x = points[i][0];
            p.y = points[i][1];
            p.val = d;
            pq.add(p);    
        }
        /*for(int i=0;i<points.length;i++){
            Point p = pq.poll();
            System.out.println(p.x+" "+p.y+" "+p.val);  
        }*/
        
        for(int i=0;i<k;i++){
            Point p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
    
}