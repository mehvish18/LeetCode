class Solution {
    public int maxProfit(int[] prices) {
        int bought=0;
        int current=1;
        
        int maxProfit=0;
        
        while(current<prices.length){
            if(prices[bought]<prices[current]){
                maxProfit = Math.max(maxProfit,prices[current]-prices[bought]);
            }else{
                bought=current;
            }
            
            current++;
        }
        
        return maxProfit;
    }
}