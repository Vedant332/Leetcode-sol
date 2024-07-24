    class Solution {
            public int countSubstrings(String s) {
            int count=0;

            for(int i=0;i<s.length();i++){
                for(int j=i;j<s.length();j++){
                    if(isPalindrome(s,i,j)){
                        count++;
                    }
               }
          }
            return count;
   }

    public boolean isPalindrome(String s, int start,int end){
        if(start>=end) return true;

       if(s.charAt(start)==s.charAt(end)){
          return isPalindrome(s,start+1,end-1);
       }

       return false;
    }
}