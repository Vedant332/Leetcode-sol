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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ds =new ArrayList<>();
        helper(root,ds,0);
        return ds;
    }

    public void helper(TreeNode root,List<Integer> ds,int count){
        if(root==null) return;

        if(ds.size()== count)ds.add(root.val);
        count++;
        helper(root.right,ds,count);
        helper(root.left,ds,count);
    }
}