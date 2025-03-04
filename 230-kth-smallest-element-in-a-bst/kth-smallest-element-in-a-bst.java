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
    int count=1;
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        func(root,k);

        return ans;
    }

    public void func(TreeNode root,int k){
        if(root==null) return;
        kthSmallest(root.left,k);
        if(count==k){
            ans=root.val;
        }
        count++;
        kthSmallest(root.right,k);
    }
}