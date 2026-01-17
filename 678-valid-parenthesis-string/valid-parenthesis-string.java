class Solution {
    public boolean checkValidString(String s) {
        int leftMin=0;
        int leftMax=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                leftMin+=1;
                leftMax+=1;
            }else if(s.charAt(i)==')'){
                leftMax-=1;
                leftMin-=1;
            }else{
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) return false;   
            leftMin = Math.max(leftMin, 0);

        }
        return (leftMin==0);
    }
}