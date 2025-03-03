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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        func(root,"");
        return sum;
    }

    public void func(TreeNode root,String temp){
        if(root==null) return;

         temp+=root.val;

        if(root.left==null && root.right==null){
            sum+=Integer.parseInt(temp);
            return;
        }

        func(root.left,temp);
        func(root.right,temp);

    }
}