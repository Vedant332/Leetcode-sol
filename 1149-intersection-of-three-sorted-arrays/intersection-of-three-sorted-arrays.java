class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i=0;
        int j=0;
        int k=0;
        List<Integer> ans =new ArrayList<>();
        while(i<arr1.length && j<arr2.length && k<arr3.length){
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            }else {
                if(arr1[i]<arr2[j]){
                    i++;
                }else if(arr2[j]<arr3[k]){
                    j++;
                }else{
                    k++;
                }
            }
        }
        return ans;
    }
}