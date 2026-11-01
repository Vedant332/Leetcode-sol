class Solution {
    public int minMergedInteger(int[] nums) {
        int n=nums.length;
    int ans=(int)1e9;
        for(int i=0;i<n-1;i+=2){
            String a = Integer.toString(nums[i]);
    String b = Integer.toString(nums[i + 1]);
            int temp= Integer.parseInt(a+b);
            ans=Math.min(ans,temp);
        }
        return ans;
    }
}