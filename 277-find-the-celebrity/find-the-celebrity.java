/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int top=0;
        int down=n-1;

        while(top<down){
            if(knows(top,down)){
                top++;
            }else {
                down--;
            }
        }

        if(top>down) return -1;

        for(int i=0;i<n;i++){
            if(top!=i){
                if(knows(top,i)||!knows(i,top)){
                    return -1;
                }
            }
        }
        return top;
    }
}