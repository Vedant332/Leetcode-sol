class Solution {
    public int minOperations(int n) {
        int steps=0;
        
        while(n>0){

            int hi=1;
            int nexthi=1;

            while(hi<n){
                nexthi=hi;
                hi=hi*2;        
            }

            int diff1= Math.abs(hi-n);
            int diff2=Math.abs(nexthi-n);

            n=Math.min(diff1,diff2);
            steps++;
        }
        return steps;
    }
}