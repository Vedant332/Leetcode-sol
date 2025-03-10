class Pair{
    String word;
    int steps;
    public Pair(String word,int steps){
        this.word=word;
        this.steps=steps;
    }
}
class Solution {
    char[] arr={'A','C','G','T'};
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<bank.length;i++){
            hs.add(bank[i]);
        }
        if (!hs.contains(endGene)) return -1;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(startGene,0));
        while(!q.isEmpty()){
            String gene=q.peek().word;
            int noOfSteps=q.peek().steps;
            q.poll();

            if(gene.equals(endGene)) return noOfSteps;


            for(int i=0;i<gene.length();i++){
                char[] charArray=gene.toCharArray();
                char originalChar=charArray[i];
                for(int j=0;j<arr.length;j++){
                    if(arr[j]==originalChar) continue;
                    charArray[i]=arr[j];
                    String newWord=new String(charArray);
                    if(hs.contains(newWord)){
                        hs.remove(newWord);
                        q.offer(new Pair(newWord,noOfSteps+1));
                    }
                }
            }
        }
        return -1;
    }
}