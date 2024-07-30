class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length+1];
        Arrays.fill(dp,-1);
        dp[days.length]=0;

        for(int ind=days.length-1;ind>=0;ind--){
            int op1=costs[0]+dp[ind+1];

        int i;
        for(i=ind;i<days.length && days[i]<days[ind]+7;i++){}

        int op2=costs[1]+dp[i];

        for(i=ind;i<days.length && days[i]<days[ind]+30;i++){}

        int op3=costs[2]+dp[i];

         dp[ind]=Math.min(op1,Math.min(op2,op3));
        }
        return dp[0];
    }

    public int func(int[] days,int[] costs,int ind,int[] dp){

        if(ind>=days.length) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int op1=costs[0]+func(days,costs,ind+1,dp);

        int i;
        for(i=ind;i<days.length && days[i]<days[ind]+7;i++){}

        int op2=costs[1]+func(days,costs,i,dp);

        for(i=ind;i<days.length && days[i]<days[ind]+30;i++){}

        int op3=costs[2]+func(days,costs,i,dp);

        return dp[ind]=Math.min(op1,Math.min(op2,op3));
    }
}