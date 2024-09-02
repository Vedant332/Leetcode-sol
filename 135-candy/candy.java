class Solution {
    public int candy(int[] ratings) {
          int i =1;
        int sum =1;
        int n = ratings.length-1;
        while(i<=n)
        {
           int peek =1;
            while( i<=n &&  ratings[i]>ratings[i-1]  )
            {
                peek = peek+1;
                sum  +=  peek;
                i++;
               
            }
            int down = 0;
            while( i<=n && ratings[i] < ratings[i-1] )
            {
                if(i==1||ratings[i-1]==ratings[i-2])
                down=1;

                down=down+1;
                sum += down;
                i++;
            }
            while(  i<=n   &&  ratings[i]==ratings[i-1])
            {
                sum += 1;
                ++i;
            }
            if(down>=peek && peek!=1)
            {
                sum += down-peek+1;
            }
            
        }
       
       return sum;
    }
}