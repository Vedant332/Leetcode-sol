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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result =new ArrayList();
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        func(root,map);

        for(List<Integer> it : map.values()){
            result.add(it);
        }
        return result;
    }

    public int func(TreeNode root, HashMap<Integer,List<Integer>> map){
        if(root==null) return 0;

        int left = func(root.left,map);
        int right=func(root.right,map);

        int height=1+Math.max(left,right);
        map.putIfAbsent(height, new ArrayList<>());
        map.get(height).add(root.val);

        return height;
    }
}