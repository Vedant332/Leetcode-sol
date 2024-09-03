class Solution {
    public String minRemoveToMakeValid(String s) {
        int count=0;
        char[] arr=s.toCharArray();

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                count++;
            }else if(arr[i]==')'){
                if(count==0) arr[i]='*';
                else count--;
            }
        }

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]=='(' && count>0){
                arr[i]='*';
                count--;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!='*') sb.append(arr[i]);
        }

        return sb.toString();
    }
}