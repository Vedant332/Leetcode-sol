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
    public TreeNode reverseOddLevels(TreeNode root) {
         helper(root.left,root.right,0);
         return root;
         
    }

    public void helper(TreeNode leftCh,TreeNode rightCh,int level){
        if(leftCh==null || rightCh==null) return;

        if(level%2==0){
            int temp=leftCh.val;
            leftCh.val=rightCh.val;
            rightCh.val=temp;
        }

        helper(leftCh.left,rightCh.right,level+1);
        helper(leftCh.right,rightCh.left,level+1);
    }
}