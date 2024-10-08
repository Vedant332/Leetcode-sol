/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node parp=findPar(p);

        return LCA(parp,p,q);

    }

    public Node LCA(Node root,Node p, Node q){
        if(root==null || p.val==root.val || q.val==root.val) return root;

        Node left=LCA(root.left,p,q);
        Node right=LCA(root.right,p,q);

        if(left==null) return right;
        else if(right==null) return left;
        else return root;
    }

    public Node findPar(Node e){
        if(e.parent== null) return e;

        return findPar(e.parent);
    }
}