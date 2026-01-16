class Solution {

    int[] vals={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        
        String ans="";

        for(int i=0;i<vals.length;i++){
            int times=num/vals[i];

            while(times!=0){
                ans+=strs[i];
                times--;
            }
            num=num%vals[i];
        }
        return ans;
    }
}