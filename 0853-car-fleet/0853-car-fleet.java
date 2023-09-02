class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Integer> mp = new HashMap<>();
        int count = 1;
        for(int i=0;i<position.length;i++){
            mp.put(position[i],speed[i]);
        }
        Arrays.sort(position);
        double [] time = new double[position.length];
        for(int i=0;i<position.length;i++){
           time[i] = (double)(target-position[i])/(double)(mp.get(position[i]));
        }
        System.out.println(Arrays.toString(position));
        System.out.println(Arrays.toString(time));
        double curTime = time[position.length-1];
        for(int i=position.length-2;i>=0;i--){
            if(curTime<time[i]){
                count++;
                curTime = time[i];
            }
        }
        
        return count;
    }
}