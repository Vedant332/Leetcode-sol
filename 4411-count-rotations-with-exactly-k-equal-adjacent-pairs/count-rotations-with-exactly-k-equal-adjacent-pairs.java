class Solution {
    public int countRotations(String s, int k) {
        int maxScore=0;
        for(int i=0;i<s.length();i++){
            String newWord=s.substring(0,i);
            String newS=s.substring(i)+newWord;
            int score=findScore(newS);
            if(score==k) maxScore+=1;
        }
        return maxScore;
    }

    public int findScore(String t){
        int scores=0;
        for(int i=1;i<t.length();i++){
            if(t.charAt(i)==t.charAt(i-1)) scores++;
        }
        return scores;
    }
}