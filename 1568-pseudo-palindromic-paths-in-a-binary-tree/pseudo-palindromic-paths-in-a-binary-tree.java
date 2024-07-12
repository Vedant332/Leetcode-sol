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
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        return func(root,map);
    }

    public int func(TreeNode root,HashMap<Integer,Integer> map){
        if (root == null) return 0;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        int count = 0;
        if (root.left == null && root.right == null) {
            if (isPalin(map)) {
                count = 1;
            }
        } else {
            count += func(root.left, map);
            count += func(root.right, map);
        }

        // Backtrack
        map.put(root.val, map.get(root.val) - 1);
        if (map.get(root.val) == 0) {
            map.remove(root.val);
        }

        return count;
    }

    private boolean isPalin(HashMap<Integer, Integer> map) {
        int oddCount = 0;
        for (int count : map.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}