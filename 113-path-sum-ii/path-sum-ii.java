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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        helper(root,targetSum,new ArrayList<>(),ans);
        return ans;
    }

    public void helper(TreeNode root,int target,List<Integer> temp,List<List<Integer>> ans){
        if(root==null) return;
        if(root.left == null && root.right ==null ){
            if(target==root.val){
                temp.add(root.val);
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }

        target-=root.val;
        temp.add(root.val);
        helper(root.left,target,temp,ans);
        helper(root.right,target,temp,ans);
        temp.remove(temp.size()-1);
    }
}