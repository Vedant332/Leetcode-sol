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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return false;
        boolean nullNode=false;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();

                if(curr==null){
                    nullNode=true;
                }else{
                    if(nullNode==true){
                        return false;
                    }
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
            
        }
        return true;
    }
}