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
    public boolean isValidBST(TreeNode root) {
     return func(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean func(TreeNode root,long minVal,long maxVal){
        if(root==null) return true;

        if(root.val>=maxVal || root.val<=minVal) return false;

        return func(root.left,minVal,root.val) && func(root.right,root.val,maxVal);
    }
}