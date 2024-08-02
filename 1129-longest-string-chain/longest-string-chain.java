class Solution {
    public int longestStrChain(String[] words) {
        int[] dp=new int[words.length];
        Arrays.fill(dp,1);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(compare(words[i],words[j])&& dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }

    public boolean compare(String i,String j){
         if(i.length()!=j.length()+1) return false;
        int first=0;
        int second=0;
        while(first!=i.length()){
            if(second < j.length() && i.charAt(first) == j.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        if(first == i.length() && second == j.length()) return true;
    else return false; 
    }
}