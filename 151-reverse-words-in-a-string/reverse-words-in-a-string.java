class Solution {
    public String reverseWords(String s) {
        String[] temp = s.trim().split("\\s+");
        int i=0;
        int j=temp.length-1;

        while(i<j){
            String curr=temp[i];
            temp[i]=temp[j];
            temp[j]=curr;
            i++;
            j--;
        }
        
        String result = String.join(" ", temp);
        return result;
    }
}