class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> map=new HashMap<>();
        Boolean[] dp = new Boolean[s.length() + 1];
    
        for(int i=0;i<wordDict.size();i++){
            map.put(wordDict.get(i),true);
        }
        return func(0,s,map,dp);
    }

    public boolean func(int ind,String s,HashMap<String,Boolean> map,Boolean[] dp){
        if(ind==s.length()) return true;
        if(dp[ind]!=null) return dp[ind]; 
        for(int i=ind+1;i<=s.length();i++){
            if(map.containsKey(s.substring(ind,i))){
                if(func(i,s,map,dp)){
                    return dp[ind]=true;
                }
            }
        }
        return dp[ind]=false;
    }
}