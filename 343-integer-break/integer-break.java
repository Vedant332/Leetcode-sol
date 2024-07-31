class Solution {
    public int integerBreak(int n) {
        return helper(n,0,1,0);
    }

    public int helper(int n,int currSum,int ind,int numTaken){

        if (currSum == n && numTaken >= 2) {
            return 1;
        } else if (currSum > n || ind >= n) {
            return 0;
        }

        if(ind<n){
            int one=ind*(helper(n,currSum+ind,ind,numTaken+1));

            int two=helper(n,currSum,ind+1,numTaken);
            return Math.max(one, two);
        }else{
            return helper(n, currSum, ind + 1, numTaken);
        }

    }
}