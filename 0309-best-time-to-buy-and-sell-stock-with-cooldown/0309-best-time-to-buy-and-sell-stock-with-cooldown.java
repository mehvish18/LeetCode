class Solution {
    int [] price;
    Map<String, Integer> dp = new HashMap<>();
    public int buySell(int index, boolean buying){
        if(index>=price.length)
            return 0;
        if(dp.get(index+" "+buying)!=null)
            return dp.get(index+" "+buying);
        int cooldown = buySell(index+1, buying);
        if(buying){
            int buy = buySell(index+1, !buying) - price[index];
            dp.put(index+" "+buying,(Math.max(buy,cooldown)));
        }
        else {
            int sell = buySell(index+2, !buying) + price[index];
            dp.put(index+" "+buying,(Math.max(sell,cooldown)));
        }
        return dp.get(index+" "+buying);
    }
    public int maxProfit(int[] prices) {
        price=prices;
        return buySell(0,true);
    }
}


