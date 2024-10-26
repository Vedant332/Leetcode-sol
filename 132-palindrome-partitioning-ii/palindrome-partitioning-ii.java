class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n+1];

        for(int ind=n-1;ind>=0;ind--){
            int minCost=Integer.MAX_VALUE;
            for(int i=ind;i<n;i++){
                if(isPalin(ind,i,s)){
                    int cost=1+dp[i+1];
                    minCost=Math.min(cost,minCost);
                }
            }
             dp[ind]=minCost;
        }
            
        
         return dp[0]-1;
    }
    public int func(int ind,String s,int n,int[] dp){
        if(ind==n) return 0;

        if(dp[ind]!=-1) return dp[ind];
        int minCost=Integer.MAX_VALUE;
        for(int i=ind;i<n;i++){
            if(isPalin(ind,i,s)){
                int cost=1+func(i+1,s,n,dp);
                minCost=Math.min(cost,minCost);
            }
        }
        return dp[ind]=minCost;
    }

    public boolean isPalin(int start,int end,String s){
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}