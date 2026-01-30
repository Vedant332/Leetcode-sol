class Solution {
    public int compress(char[] chars) {
        int i=0;
        int j=0;
        int count=0;
        int write=0;

        while(j<chars.length){

            while(j<chars.length && chars[i]==chars[j]){
                j++;
                count++;
            }

            chars[write]=chars[i];
            write++;
            
            if(count>1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[write++]=c;
                }
            }
            i=j;
            count=0;
        }
        return write;
    }
}