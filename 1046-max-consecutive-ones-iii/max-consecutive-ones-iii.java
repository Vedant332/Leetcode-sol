class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        int maxi=Integer.MIN_VALUE;
        while(j<n){
            if(nums[j]==1){
                 maxi=Math.max(maxi,j-i+1);
                j++;
            }else if(nums[j]==0 && k>0){
                 maxi=Math.max(maxi,j-i+1);
                j++;
                k--;
            }else{
                while(k==0){
                    if(nums[i]==0){
                        k++;
                    }
                    i++;
                }
            }
        }
        return maxi;
    }
}