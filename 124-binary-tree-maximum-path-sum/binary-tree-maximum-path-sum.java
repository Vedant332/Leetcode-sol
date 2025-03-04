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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         func(root);
         return maxSum;
    }

    public int func(TreeNode root){
        if(root==null) return 0;

        int left=Math.max(0,func(root.left));
        int right=Math.max(0,func(root.right));

        int sum=root.val+left+right;
        maxSum=Math.max(sum,maxSum);

        return root.val+Math.max(left,right);
    }
}