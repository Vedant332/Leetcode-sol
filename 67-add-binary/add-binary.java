class Solution {
    public String addBinary(String a, String b) {
        int l=a.length()-1;
        int r=b.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(l>=0 || r>=0 || carry!=0){
            int sum=carry;
            if(l>=0) sum+=a.charAt(l)-'0';
            if(r>=0) sum+=b.charAt(r)-'0';
            sb.append(sum%2);
            carry=sum/2;
            l--;
            r--;
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
}