class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        int n=s1.length();
        List<List<String>> ans =new ArrayList<>();
        String a = "";
        String b = "";
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                a += s1.charAt(i);
                b += s2.charAt(i);
            }else{
                 if (!a.isEmpty()) {
                    List<String> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(b);
                    ans.add(temp);

                    a = "";
                    b = "";
                }
            }
        }
        if (!a.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(a);
            temp.add(b);
            ans.add(temp);
        }
        return ans;
    }
}