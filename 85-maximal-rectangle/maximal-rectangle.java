class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] prefix=new int[m][n];

         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    prefix[i][j] = (i == 0 ? 1 : prefix[i - 1][j] + 1);
                } else {
                    prefix[i][j] = 0;
                }
            }
        }
        int maxArea=0;
        for(int i=0;i<m;i++){
            maxArea=Math.max(maxArea,LHA(prefix[i]));
        }
        return maxArea;
    }

    public int LHA(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                int ele=st.pop();
                int pse=st.isEmpty()?-1: st.peek();
                int nse=i;
                maxArea=Math.max(maxArea,(nse-pse-1)*nums[ele]);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int ele=st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1: st.peek();
            maxArea=Math.max(maxArea,(nse-pse-1)*nums[ele]);
        }
        return maxArea;
    }
}