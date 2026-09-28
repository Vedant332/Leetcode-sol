class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int ans=0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            int a =nums[i];
            int b=nums[i+1];
            if(a==b){
                ans++;
            }else if(map.containsKey(a+"-"+b)){
                map.put(a+"-"+b,map.get(a+"-"+b)+1);
            }else if(map.containsKey(b+"-"+a)){
                 map.put(b+"-"+a,map.get(b+"-"+a)+1);
            }else{
                map.put(a+"-"+b,1);
            }
        }
        int freq=0;
        for(String it : map.keySet()){
            freq=Math.max(map.get(it),freq);
        }
        return ans+freq;
    }
}