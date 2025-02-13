class Solution {

    public int next(int n){
        int sum=0;

        while(n!=0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=next(n);

        while(slow!=fast){
            slow=next(slow);
            fast=next(next(fast));
        }

        return (slow==1);
    }
}