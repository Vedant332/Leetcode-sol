class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int M=(int)1e9+7;

        int[] NSL=getNsl(arr,n);
        int[] NSR=getNSR(arr,n);
         long sum=0;

        for(int i=0;i<n;i++){
           long ls=i-NSL[i];
           long rs=NSR[i]-i;

           long totalWays=ls*rs;

           long totalSum=arr[i]*totalWays;

          sum=(sum+totalSum)%M;
        }
        return (int)sum;
    }

    public int[] getNsl(int[] arr,int n){
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty() ? -1:st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public int[] getNSR(int[] arr,int n){
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                ans[i]=n;
            }else{
                while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                    st.pop();
                }
                ans[i]=st.isEmpty() ? n : st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}