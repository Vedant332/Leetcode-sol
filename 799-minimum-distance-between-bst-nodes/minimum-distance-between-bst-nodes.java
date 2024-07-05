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
    public int minDiffInBST(TreeNode root) {
       List<Integer> ans=new ArrayList<>();
       func(root,ans);
       int diff=Integer.MAX_VALUE;
       for(int i=0;i<ans.size()-1;i++){
        int curr=ans.get(i+1)-ans.get(i);
        diff=Math.min(diff,curr);
       }

       return diff;

    }

    public void func(TreeNode root,List<Integer> ans){
        if(root==null) return;

        func(root.left,ans);
        ans.add(root.val);
        func(root.right,ans);
    }
}