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
     private int moves;
    public int distributeCoins(TreeNode root) {
        moves=0;
        func(root);
        return moves;
    }

    public int func(TreeNode root){
        if(root==null) return 0;

        int leftExcess=func(root.left);
        int rightExcess=func(root.right);

        moves+=Math.abs(root.val+leftExcess+rightExcess-1);
        return  root.val+leftExcess+rightExcess-1;
    }
}