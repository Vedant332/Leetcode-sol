class Solution {
    public boolean splitString(String s) {
        return helper(s,0,-1,0);
    }

    public boolean helper(String s,int ind,long prev,int count){
        if(ind==s.length()){
            return count>1;
        }
        long curr=0;
        for(int i=ind;i<s.length();i++){
             curr = curr*10+(s.charAt(i)-'0');
            if(prev==-1 || prev-curr==1){
                if(helper(s,i+1,curr,count+1)){
                    return true;
                }
            }
        }
        return false;
    }
}