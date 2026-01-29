class Solution {
    public int secondsToRemoveOccurrences(String s) {
     int seconds=0;
     int zeros=0;
     for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='0'){
            zeros++;
        }else{
            if(zeros>0){
                seconds=Math.max(seconds+1,zeros);
            }
        }
     }   
     return seconds;
    }
}