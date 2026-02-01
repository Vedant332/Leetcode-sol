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

    public boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        else return false;
    }

    public void addLeftBoundary(TreeNode root, List<Integer> ans){
        TreeNode curr =root.left;
        while(curr!=null){
            if(!isLeaf(curr)) ans.add(curr.val);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }

    public void addRightBoundary(TreeNode root, List<Integer> ans){
        TreeNode curr =root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)) temp.add(curr.val);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
        }

        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }

    public void addLeaves(TreeNode root, List<Integer> ans){
        if(isLeaf(root)) ans.add(root.val);

        if(root.left!=null) addLeaves(root.left,ans);
        if(root.right!=null) addLeaves(root.right,ans);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(!isLeaf(root)) ans.add(root.val);
        addLeftBoundary(root,ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);
        return ans;
    }
}