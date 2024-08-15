class Pair{
    String code;
    int moves;
    public Pair(String code,int moves){
        this.code=code;
        this.moves=moves;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> hs=new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            hs.add(deadends[i]);
        }
        if(hs.contains("0000")) return -1;
        Queue<Pair> pq=new LinkedList<>();
        pq.add(new Pair("0000",0));
        visited.add("0000");
        while(!pq.isEmpty()){
            int size=pq.size();
            for(int i=0;i<size;i++){
                String s=pq.peek().code;
                int minMoves=pq.peek().moves;
                pq.poll();

                if(hs.contains(s)) continue;
                if(s.equals(target)) return minMoves;

                for(int j=0;j<4;j++){

                     StringBuilder sb1 = new StringBuilder(s);
                    char c1 = (char)((s.charAt(j) - '0' + 1) % 10 + '0');
                    sb1.setCharAt(j, c1);
                    String code1 = sb1.toString();

                    StringBuilder sb2 = new StringBuilder(s);
                    char c2 = s.charAt(j) > '0' ?
                            (char) ((s.charAt(j) - '0' - 1) % 10 + '0') :
                            (char) ((10 - (s.charAt(j) - '0') - 1) % 10 + '0');
                    sb2.setCharAt(j, c2);
                    String code2 = sb2.toString();

                    if(!hs.contains(code1) && !visited.contains(code1)){
                        visited.add(code1);
                        pq.add(new Pair(code1,minMoves+1));
                    }

                    if(!hs.contains(code2) && !visited.contains(code2)){
                        visited.add(code2);
                        pq.add(new Pair(code2,minMoves+1));
                    }
                }

            }
        }
        return -1;
    }
}