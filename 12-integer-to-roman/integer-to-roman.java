class Solution {
    int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
         String res="";
        
        for(int i=0;i<values.length;i++){
            if(num==0) break;

            int times=num/values[i];

            while(times!=0){
                res+=strs[i];
                times--;
            }
            num=num % values[i];
        }
        return res;
    }
}