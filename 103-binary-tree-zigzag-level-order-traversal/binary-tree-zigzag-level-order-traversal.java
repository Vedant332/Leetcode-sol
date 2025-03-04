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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode ele=q.poll();
               if(ele.left!=null) q.offer(ele.left);
               if(ele.right!=null) q.offer(ele.right);
               if(leftToRight){
                temp.addLast(ele.val);
               }else{
                temp.addFirst(ele.val);
               }
            }
            leftToRight=!leftToRight;
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}