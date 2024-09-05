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
        helper(0,digits,map,ans,new StringBuilder());
        return ans;
    }

    public void helper(int ind,String digits,HashMap<Character,String> map,List<String> ans,StringBuilder sb){
        if(ind==digits.length()){
            ans.add(sb.toString());
            return;
        }

        String temp=map.get(digits.charAt(ind));

        for(int i=0;i<temp.length();i++){
            sb.append(temp.charAt(i));
            helper(ind+1,digits,map,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}