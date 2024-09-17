class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> ls=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ls.add(nums[i]);
            }else{
                map.put(nums[i],1);
            }
        }
        int[] arr = ls.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}