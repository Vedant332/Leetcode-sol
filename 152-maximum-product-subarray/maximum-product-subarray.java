class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int maxProd = nums[0];
        int preProd=1;
        int suffProd=1;


        for(int i=0;i<nums.length;i++){
            preProd=preProd*nums[i];
            suffProd=suffProd*nums[n-i-1];
            maxProd=Math.max(preProd,Math.max(suffProd,maxProd));

            if(preProd == 0) preProd = 1;
            if(suffProd == 0) suffProd = 1;
        }
        return maxProd;
    }
}