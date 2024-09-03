class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int ini=money;
        int chocs=0;
        for(int i=0;i<prices.length;i++){
            if(money<0 || chocs==2) break;
            money-=prices[i];
            chocs++;
        }
        if(money<0) return ini;
        else return money;
    }
}