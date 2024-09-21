class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int[] result=new int[m+n];

        if(m==0 || n==0 || "0".equals(num1) || "0".equals(num2)) return "0";

        if("1".equals(num1)) return num2;

        if("1".equals(num2)) return num1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int prod=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');

                prod+=result[i+j+1];

                result[i+j+1]=prod%10;
                result[i+j]+=prod/10;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<result.length;i++){
            if(i==0 && result[i]==0) continue;
            sb.append(result[i]);
        }

        return sb.toString();
    }
}