class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
        }
            return sol(x,n);
    }

    public double sol(double x,int n){
        if(n==0) return 1.0;

        double ele=sol(x,n/2);
        if(n%2==0) return ele*ele;
        else return x*ele*ele;
    }
}