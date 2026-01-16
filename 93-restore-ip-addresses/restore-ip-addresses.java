class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        if(s.length()>12 || s.length()<4) return ans;
        helper(0,s,ans,"",0);
        return ans;
    }

    public void helper(int ind,String s,List<String> ans, String temp,int parts){
        if(ind==s.length() && parts==4){
            ans.add(temp.substring(0,temp.length()-1));
            return;
        }

        if(parts>=4|| ind>s.length()) return;


        for(int i=1;i<=3;i++){
            if(ind+i>s.length()) break;
            if(isValid(s.substring(ind,ind+i))){
                helper(ind+i,s,ans,temp+s.substring(ind,ind+i)+".",parts+1);
            }
        }
    }

    public boolean isValid(String t){
        if(t.length()>1 && t.startsWith("0")) return false;
        int num=Integer.parseInt(t);
        return num>=0 && num<=255;
    }
}