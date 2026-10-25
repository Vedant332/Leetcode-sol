class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        long sum=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            int num=nums[i];
            char[] digits = String.valueOf(num).toCharArray();
            Arrays.sort(digits);

            String reversed = new StringBuilder(new String(digits))
              .reverse()
             .toString();

            int newNum = Integer.parseInt(reversed);

            pq.offer(newNum-num);
        }

        while(k!=0){
            sum+=pq.poll();
            k--;
        }
        return sum;
    }
}