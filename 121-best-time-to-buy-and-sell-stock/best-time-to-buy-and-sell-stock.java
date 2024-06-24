class Solution {
    public int maxProfit(int[] prices) {
        int buyprice=prices[0];
        int profit=0;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(buyprice>prices[i]){
                buyprice=prices[i];
            }
            profit=prices[i]-buyprice;
            maxProfit=Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}