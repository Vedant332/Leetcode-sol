class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans=new ArrayList<>();
        HashMap<String,Boolean> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();

        for(String it: wordDict){
            map.put(it,true);
        }
        func(s,0,map,"",ans);

        return ans;
    }
    public void func(String s,int ind, HashMap<String,Boolean> map,String sb,List<String> ans){
        if(ind==s.length()){
              ans.add(sb.trim());
              return ;
        }

        for(int i=ind+1;i<s.length()+1;i++){
            if(map.containsKey(s.substring(ind,i))){
                func(s,i,map,sb+s.substring(ind,i)+" ",ans);
            }
        }
    }
}