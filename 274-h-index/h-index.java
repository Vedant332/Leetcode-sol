class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        int l=0;
        int r=citations.length;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(search(citations,mid) >=mid){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l-1;
    }

    public int search(int[] arr,int h){
        int ans=0;

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=h){
                ans++;
            }
        }
        return ans;
    }
}