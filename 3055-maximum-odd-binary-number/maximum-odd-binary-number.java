class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] ch=s.toCharArray();

        Arrays.sort(ch);
        int i=ch.length-2;
        int j=0;

        while(i>=j){
            char c=ch[i];
            ch[i]=ch[j];
            ch[j]=c;
            i--;
            j++;
        }
        return String.valueOf(ch);
    }
}