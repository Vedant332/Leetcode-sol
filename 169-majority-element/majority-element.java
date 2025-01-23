class Solution {
    public int majorityElement(int[] nums) {
        int possibleCandidate=0;
        int freq=0;

        for(int i=0;i<nums.length;i++){
            if(freq==0){
                possibleCandidate=nums[i];
            }
            if(nums[i]==possibleCandidate){
                freq++;
            }else{
                freq--;
            }
        }
        return possibleCandidate;
    }
}