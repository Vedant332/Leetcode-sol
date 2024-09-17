class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> map= new HashMap<>();
        Boolean[] dp=new Boolean[s.length()+1];
        for(String it : wordDict){
            map.put(it,true);
        }

        return func(s,0,map,dp);
    }

    public boolean func(String s,int ind,HashMap<String,Boolean> map,Boolean[] dp){
        if(ind==s.length()) return true;
        if(dp[ind]!=null) return dp[ind];
        for(int i=ind+1;i<=s.length();i++){
            if(map.containsKey(s.substring(ind,i))){
                if(func(s,i,map,dp)){
                    return dp[i]=true;
                }
            }
        }
        return dp[ind]=false;
    }
}