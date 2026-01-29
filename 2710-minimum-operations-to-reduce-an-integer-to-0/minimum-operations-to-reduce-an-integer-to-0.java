class Solution {
    public int minOperations(int n) {
        int count=0;

        while(n>0){
            count++;

            double c = Math.log(n)/Math.log(2);

            int prevPow= (int) Math.pow(2,(int)c);
            int nextPow=(int) Math.pow(2,(int) c+1);

            int diff1=n-prevPow;
            int diff2=nextPow-n;

            if(diff1 < diff2) n = diff1;
         else n = diff2;
        }
        return count;
    }
}