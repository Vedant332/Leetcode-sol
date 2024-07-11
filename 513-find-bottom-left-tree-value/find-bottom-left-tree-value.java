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
    int level=0;
    public int findBottomLeftValue(TreeNode root) {
        if(root.left==null && root.right==null) return root.val;
        int[] leftVal=new int[1];
        leftVal[0]=Integer.MIN_VALUE;
        func(root,0,leftVal);
        return leftVal[0];
    }

    public void func(TreeNode root,int max,int[] leftVal){
        if(root==null) return ;

        if(root.left==null){
            if(level<max){
                level=max;
                leftVal[0]=root.val;
            }
        }

        func(root.left,max+1,leftVal);
        func(root.right,max+1,leftVal);
    }
}