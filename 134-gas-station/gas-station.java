class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalGas=0;
        int totalCost=0;
        for(int i=0;i<n;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalCost>totalGas) return -1;

        int startIndex=0;
        int remainGas=0;
        for(int i=0;i<n;i++){
            remainGas=remainGas+(gas[i]-cost[i]);

            if(remainGas<0){
                startIndex=i+1;
                remainGas=0;
            }
        }
        return startIndex;
    }
}