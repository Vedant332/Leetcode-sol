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
    int ans=-1;
    double diff=Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if(root==null) return ans;

        double currDiff=Math.abs((double)root.val-target);
        if(currDiff < diff || (currDiff == diff && root.val < ans)){
            diff=currDiff;
            ans=root.val;
        } 
       if(root.val>target){
            closestValue(root.left,target);
        }else{
            closestValue(root.right,target);
        }

        return ans;
    }
}