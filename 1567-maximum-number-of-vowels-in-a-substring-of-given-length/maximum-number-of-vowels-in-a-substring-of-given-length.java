class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Integer> vowels = new HashSet<>();
        int temp=0;
        int ans=0;
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowels.add(j);
                temp++;
            }
            if(j-i+1<k){
                j++;
            }else{
                ans=Math.max(ans,temp);
                if(vowels.contains(i)){
                    vowels.remove(i);
                    temp--;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}