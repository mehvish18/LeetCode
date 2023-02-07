class Solution {
    public class CustomComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]-o2[0];
        }
    }   
    public int[][] merge(int[][] intervals) {
        List<int[]> lst=Arrays.asList(intervals);
        Collections.sort(lst, new CustomComparator());
        int s=intervals[0][0],t=intervals[0][1];
        List<int[]> ans= new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(s<=intervals[i][0] && intervals[i][0]<=t) {
                t = Math.max(t,intervals[i][1]);
            }
            else {
                int [] n = new int[2];
                n[0]=s;
                n[1]=t;
                ans.add(n);
                s=intervals[i][0];
                t=intervals[i][1];   
            }
        }
        int [] n = new int[2];
        n[0]=s;
        n[1]=t;
        ans.add(n);
        int[][] a = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            a[i]=ans.get(i);
        }
        return a;
    }
}