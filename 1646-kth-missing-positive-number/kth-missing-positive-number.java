class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        int ind=1;
        int ktEle=0;
        int ele=0;

        while(ktEle!=k){
            if(!hs.contains(ind)){
                ktEle++;
                ele=ind;
            }
            ind++;
        }
        return ele;
    }
}