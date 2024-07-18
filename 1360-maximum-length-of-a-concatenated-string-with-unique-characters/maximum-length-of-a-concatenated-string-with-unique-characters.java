class Solution {
    public int maxLength(List<String> arr) {
        return solve(arr,0,"");
    }

    public int solve(List<String> arr,int ind,String soFar){
        if(ind==arr.size()){
            if(isValid(soFar)){
                return soFar.length();
            }
            return 0;
        }

        int take=solve(arr,ind+1,soFar+arr.get(ind));
        int notTake=solve(arr,ind+1,soFar);

        return Math.max(take,notTake);
    }

    public boolean isValid(String s){
        int[] freq=new int[26];

        for(int i=0;i<s.length();i++){
           int val=s.charAt(i)-'a';
           freq[val]++;

           if(freq[val]>1){
            return false;
           }
        }
        return true;
    }
}