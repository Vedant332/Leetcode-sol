class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        helper(digits,0,map,new StringBuilder(),ans);
        return ans;
    }

    public void helper(String digits,int ind,HashMap<Character,String> map,StringBuilder sb, List<String> ans){
        if(ind==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String str=map.get(digits.charAt(ind));
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            helper(digits,ind+1,map,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}