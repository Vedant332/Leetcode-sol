class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] cars=new int[n][2];

        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Stack<Double> st=new Stack<>();

        Arrays.sort(cars, (a,b)->Integer.compare(b[0],a[0]));

        for(int i=0;i<n;i++){
            int dis=target-cars[i][0];
            int spee=cars[i][1];

            double tm=(double)dis/spee;
            if(!st.isEmpty() && st.peek()>=tm){
                continue;
            }
            st.push(tm);
        }
        return st.size();
    }
}