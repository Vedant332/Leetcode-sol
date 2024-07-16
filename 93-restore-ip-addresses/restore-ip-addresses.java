class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        if(s.length()>12 || s.length()<4) return ans;
        helper(s,0,ans,"",0);
        return ans;
    }

    public void helper(String s,int ind, List<String> ans,String temp,int segment){
        if(ind==s.length() && segment==4){
            ans.add(temp.substring(0,temp.length()-1));
            return;
        }

        if(segment>=4||ind>=s.length()){
            return ;
        }
        for(int i=1;i<=3;i++){
            if(ind+i>s.length()) break;
            String part=s.substring(ind,ind+i);
            if(isValid(part)){
                    helper(s,ind+i,ans,temp+part+".",segment+1);
            }
        }
        
    }

    public boolean isValid(String s){
        if(s.length()>1 && s.startsWith("0")) return false;
        int num=Integer.parseInt(s);
        return num>=0 && num<=255;
    }
}