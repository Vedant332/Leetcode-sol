class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
    List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int first=nums[i];
            int l=i+1;
            int r=n-1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while(l<r){
                if(first+ nums[l] +nums[r]==0){
                    List<Integer> temp =new ArrayList<>();
                    temp.add(first);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if(first+ nums[l] +nums[r]>0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }
}