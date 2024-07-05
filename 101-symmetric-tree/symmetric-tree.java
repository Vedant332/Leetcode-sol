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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;

        if(root1==null|| root2==null) return false;

        if(root1.val!=root2.val) return false;

            boolean left=helper(root1.left,root2.right);
            boolean right=helper(root1.right,root2.left);

            if(left==false || right==false){
                return false;
            }else{
                return true;
            }
    }
}