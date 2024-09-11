class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int j=nums.length-1;
            int k=i+1;

            while(k<j){
                 int sum=nums[i]+nums[j]+nums[k];
    
             if(Math.abs(target-closest)>Math.abs(target-sum)){
                closest=sum;
            }

            if(sum<target){
                k++;
            }else{
                j--;
            }
            }
        }
        return closest;
    }
}