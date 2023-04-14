class Solution {
    public int maxProfit(int[] prices) {
        int [] maxValues = new int[prices.length];
        int max=0;
        for(int i=prices.length-1;i>=0;i--){
            max = Math.max(max, prices[i]);
            maxValues[i]= max;
        }
        //System.out.println(Arrays.toString(maxValues));
        max=0;
        for(int j=0;j<prices.length;j++){
            max = Math.max(max,(maxValues[j]-prices[j]));
        }
        return max;
        
    }
}