class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();
        for(int i=0;i<timePoints.size();i++){
            String [] hhMM = timePoints.get(i).split(":");
            int totalTime = Integer.parseInt(hhMM[0])*60+Integer.parseInt(hhMM[1]);
            time.add(totalTime);
        }
        Collections.sort(time);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<time.size();i++){
            int diff = time.get(i)-time.get(i-1);
            min = Math.min(min,diff);
        }
        int diff = time.get(0)+1440 - time.get(time.size()-1);
        min = Math.min(min,diff);
        return min;
    }
        
}

