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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            double size=q.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode ele=q.poll();
                sum+=ele.val;
                if(ele.left!=null) q.offer(ele.left);
                if(ele.right!=null) q.offer(ele.right);
            }
            double avg=sum/size;
            ans.add(avg);
        }
        return ans;
    }
}