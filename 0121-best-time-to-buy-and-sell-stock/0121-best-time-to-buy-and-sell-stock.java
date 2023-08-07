class Solution {
    public int maxProfit(int[] prices) {
        int [] maxArr = new int[prices.length];
        int max = 0;
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>max)
                max = prices[i];
            maxArr[i] = max;
        }
        int ans =0;
        for(int i=0;i<prices.length;i++){
            if(ans<(maxArr[i]-prices[i]))
                ans = maxArr[i]-prices[i];
        }
        return ans;
    }
}