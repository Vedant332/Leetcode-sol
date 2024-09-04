class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i=0;
        int j=0;
        while(i<word.length() && j<abbr.length()){
            if(word.charAt(i)==abbr.charAt(j)){
                i++;
                j++;
            }else{
                if(Character.isDigit(abbr.charAt(j))){
                    if (abbr.charAt(j) == '0') {
                    return false;
                }
                    String num="";
                    while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                        num+=abbr.charAt(j);
                        j++;
                    }
                     i=func(word,i,Integer.parseInt(num));
                    if(i==-1) return false;
                }else{
                    return false;
                }
            }
        }
        return i==word.length() && j==abbr.length();
    }

    public int func(String word,int ind,int num){
        while(num!=0){
            ind++;
            num--;
        }
        if(word.length()<ind) return -1;
        return ind;
    }
}