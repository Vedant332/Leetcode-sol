class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res=new int[nums.length];

        int lo=0;
        int hi=nums.length-1;
        int ind=nums.length-1;

        while(lo<=hi){
            int sqlo=nums[lo]*nums[lo];
            int sqhi=nums[hi]*nums[hi];
            if( sqlo < sqhi){
                res[ind--]=sqhi;
                hi--;
            }else{
                res[ind--]=sqlo;
                lo++;
            }
        }
        return res;
    }
}