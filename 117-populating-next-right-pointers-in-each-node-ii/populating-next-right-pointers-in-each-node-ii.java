/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Pair{
    Node node;
    int level;
    public Pair(Node node,int level){
        this.node=node;
        this.level=level;
    }
}
class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node ele=q.peek().node;
                int lev=q.peek().level;
                q.poll();
                if(!q.isEmpty() && q.peek().level ==lev){
                    ele.next=q.peek().node;
                }else{
                    ele.next=null;
                }
                if(ele.left!=null){
                    q.offer(new Pair(ele.left,lev+1));
                }
                if(ele.right!=null){
                    q.offer(new Pair(ele.right,lev+1));
                }
            }
        }
        return root;
    }
}