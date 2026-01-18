class Solution {
    public int minimumBuckets(String hamsters) {
        char[] ch=hamsters.toCharArray();

        for(int i=0;i<ch.length;i++){
            if(ch[i]=='H'){

                if(i-1>=0 && ch[i-1]=='B'){
                    continue;
                }
                 if(i+1<ch.length && ch[i+1]=='.'){
                    ch[i+1]='B';
                 }else if(i-1>=0 && ch[i-1]=='.'){
                    ch[i-1]='B';
                 }else{
                    return -1;
                 }
            }
        }

        int count=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='B'){
                count++;
            }
        }
        return count;
    }
}