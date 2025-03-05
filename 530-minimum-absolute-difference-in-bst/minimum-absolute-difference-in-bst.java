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
    int minDiff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        int[] prev=new int[1];
        prev[0]=Integer.MAX_VALUE;
        func(root,prev);
        return minDiff;
    }

    public void func(TreeNode root,int[] prev){
        if(root==null) return;

        func(root.left,prev);
        if(prev[0]!=Integer.MAX_VALUE) minDiff=Math.min(minDiff,Math.abs(prev[0]-root.val));

        prev[0]=root.val;
        func(root.right,prev);

       
    }
}