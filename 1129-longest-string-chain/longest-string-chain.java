class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(x,y)->x.length()-y.length());
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(compare(words[j],words[i],0,0) && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }

    public boolean compare(String s,String t,int i,int j){
        if (t.length() - s.length() != 1) return false;
        
        while(j<t.length() && i<s.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return (i==s.length());
    }
}