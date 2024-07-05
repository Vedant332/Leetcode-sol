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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum=new int[1];
        sum[0]=func(root,low,high,sum);
        return sum[0];
    }

    public int func(TreeNode root, int low, int high,int[] sum){
        if(root==null) return 0;

        if(low<=root.val && root.val<=high){
            sum[0]=sum[0]+root.val;
        }
        func(root.left,low,high,sum);
        func(root.right,low,high,sum);

        return sum[0];
    }
}