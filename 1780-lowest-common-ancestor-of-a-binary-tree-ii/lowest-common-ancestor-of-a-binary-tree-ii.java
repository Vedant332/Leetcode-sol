/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!exists(root, p) || !exists(root, q)) {
            return null; 
        }
        return LCA(root,p,q);
    }

    public boolean exists(TreeNode root, TreeNode ele){
        if(root==null) return false;
        if(root.val==ele.val) return true;
        return exists(root.left,ele) || exists(root.right,ele);
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || p == root || q==root) return root;

        TreeNode left=LCA(root.left,p,q);
        TreeNode right=LCA(root.right,p,q);

        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }
}