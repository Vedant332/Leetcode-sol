class Pair{
    String word;
    int steps;
    public Pair(String word,int steps){
        this.word=word;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        hs.remove(beginWord);

        int totSteps=0;

        while(!q.isEmpty()){
            String w=q.peek().word;//word
            int s=q.peek().steps;//steps
            q.poll();

            if(w.equals(endWord)) totSteps=s;

            for(int i=0;i<w.length();i++){
                char[] charArr=w.toCharArray();
                for(char j='a';j<='z';j++){
                    charArr[i]=j;
                    String charArray=new String(charArr);
                    if(hs.contains(charArray)){
                        hs.remove(charArray);
                        q.offer(new Pair(charArray,s+1));
                    }
                }
            }
        }
        return totSteps;
    }
}