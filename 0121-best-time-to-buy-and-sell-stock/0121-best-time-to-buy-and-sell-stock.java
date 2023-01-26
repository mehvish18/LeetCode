class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int diff=0,maxDiff=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min)
                min=prices[i];
            diff = prices[i]-min;
            maxDiff = Math.max(diff,maxDiff);
        }
        return maxDiff;
    }
}