class Pair {
    int sum;
    int i, j; 

    public Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<String> hs=new HashSet<>();
        pq.add(new Pair(nums1[0]+nums2[0],0,0));
        hs.add("0,0");


        while(k-- >0 && !pq.isEmpty()){
           Pair p = pq.poll(); 
            int x = p.i;
            int y = p.j;

            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[x]); 
            temp.add(nums2[y]); 
            ans.add(temp);

            if (x + 1 < nums1.length && !hs.contains((x + 1) + "," + y)) {
                pq.add(new Pair(nums1[x + 1] + nums2[y], x + 1, y));
                hs.add((x + 1) + "," + y);
            }

            if (y + 1 < nums2.length && !hs.contains(x + "," + (y + 1))) {
                pq.add(new Pair(nums1[x] + nums2[y + 1], x, y + 1)); 
                hs.add(x + "," + (y + 1));
            }
        }
            return ans;
    }
}