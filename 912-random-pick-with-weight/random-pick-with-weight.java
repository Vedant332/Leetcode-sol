class Solution {
    int[] sum;
    Random r=new Random();
    int max=0;
    public Solution(int[] w) {
        sum=new int[w.length];
        sum[0]=w[0];
        for(int i=1;i<w.length;i++){
            sum[i]=sum[i-1]+w[i];
        }
        max=sum[w.length-1];
    }
    
    public int pickIndex() {
        int low=0;
        int high=sum.length-1;

        int target=1+r.nextInt(max);

        while(low<=high){
            int mid=low+(high-low)/2;

            if(sum[mid]==target){
                return mid;
            }else if(sum[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */