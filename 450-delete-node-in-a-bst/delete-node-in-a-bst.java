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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            // Case 1: Node with only one child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 2: Node with two children
            // Find the in-order successor (smallest in the right subtree)
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;  // Replace the value with the successor's value
            root.right = deleteNode(root.right, minNode.val);  // Delete the successor
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}