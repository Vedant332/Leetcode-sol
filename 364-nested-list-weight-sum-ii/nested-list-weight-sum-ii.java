/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int n=nestedList.size();
        int maxDepth=1;
        maxDepth=func(nestedList,1);

       int ans= calculate(nestedList,maxDepth,1);

       return ans;
       
    }
    public int calculate(List<NestedInteger> list,int max,int depth){
        int sum = 0;

        for(int i=0;i<list.size();i++){
            if(list.get(i).isInteger()){
                int weight=max-depth+1;
                sum+=list.get(i).getInteger() * weight;
            }else{
                sum+= calculate(list.get(i).getList(),max,depth+1);
            }
        }
        return sum;
    }

    public int func(List<NestedInteger> list,int depth){
        int maxDepth=1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).isInteger()){
                maxDepth=Math.max(maxDepth,depth);
            }else{
                maxDepth=Math.max(maxDepth,func(list.get(i).getList(),depth+1));
            }
        }
        return maxDepth;
    }
}