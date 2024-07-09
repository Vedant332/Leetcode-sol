/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        int[] count=new int[1];
        count[0]=0;
       return func(root,count,Integer.MIN_VALUE);
    }
    public int func(TreeNode root,int[] count,int max){
        if(root==null) return 0;

        max=Math.max(max,root.val);
        if(max<=root.val){
            count[0]++;
        }
        func(root.left,count,max);
        func(root.right,count,max);

        return count[0];
    }
}