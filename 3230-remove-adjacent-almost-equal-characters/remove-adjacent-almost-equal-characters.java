class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int i=1;
        int count=0;
        int n= word.length();

        while(i<n){
            if(Math.abs(word.charAt(i)-word.charAt(i-1))<=1 ){
                count++;
                i=i+2;
                continue;
            }
            i++;
        }
        return count;
    }
}