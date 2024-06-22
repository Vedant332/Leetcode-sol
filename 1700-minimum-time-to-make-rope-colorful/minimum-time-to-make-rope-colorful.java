class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=0;
        int j=1;
        int minCost=0;

        while(j<colors.length()){
            if(colors.charAt(i)==colors.charAt(j)){
                if(neededTime[i]<neededTime[j]){
                    minCost+=neededTime[i];
                    i=j;
                }else{
                    minCost+=neededTime[j];
                }
            }else{
                i=j;
            }
            j++;
        }
        return minCost;
    }
}