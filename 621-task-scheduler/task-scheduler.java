class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b) -> Integer.compare(map.get(b), map.get(a)));
        for(Character ch : map.keySet()){
            pq.offer(ch);
        }
        int ans=0;
        int count=0;
        while(!pq.isEmpty()){
            List<Character> ls=new ArrayList<>();
            while(count!=n+1 && !pq.isEmpty()){
                char c=pq.poll();
                map.put(c, map.get(c) - 1);
                if(map.get(c)>0){
                    ls.add(c);
                }
                count++;
            }
            if (ls.isEmpty() && pq.isEmpty()) {
                ans += count;       
            } else {
                ans += n + 1;       
            }
            count=0;
            for(Character nums : ls){
                pq.offer(nums);
            }
        }
        return ans;
    }
}