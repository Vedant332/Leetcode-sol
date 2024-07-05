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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1=new ArrayList<>();
        List<Integer> tree2 =new ArrayList<>();

        generateList(root1,tree1);
        generateList(root2,tree2);

        if(tree1.size()!=tree2.size()) return false;

        for(int i=0;i<tree1.size();i++){
            int val1=tree1.get(i);
            int val2=tree2.get(i);
            if(val1!=val2) return false;
        }
        return true;

    }

    public void generateList(TreeNode root,List<Integer> ans){
        if(root==null) return;

        if(root.left==null && root.right==null){
            ans.add(root.val);
        }
        generateList(root.left,ans);
        generateList(root.right,ans);
    }
}