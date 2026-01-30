/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        int[] diameter=new int[1];
        helper(root,diameter);
        return diameter[0];
    }

    public int helper(Node root, int[] diameter){
        if(root==null) return 0;

        int max1=0;
        int max2=0;

        for(Node x : root.children){
            int height=helper(x,diameter);

            if(height> max1){
                max2=max1;
                max1=height;
            }else if(height> max2){
                max2=height;
            }
        }
        diameter[0]=Math.max(diameter[0], max1+max2);

        return 1+max1;
    }
}