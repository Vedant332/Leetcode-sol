/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map =new HashMap<>();
        return cloneUtil(node,map);
    }

    public Node cloneUtil(Node node, HashMap<Node,Node> map){
        Node newNode=new Node(node.val);
        map.put(node,newNode);

        for(Node it : node.neighbors){
            if(!map.containsKey(it)){
                newNode.neighbors.add(cloneUtil(it,map));
            }else{
                newNode.neighbors.add(map.get(it));
            }
        }
        return newNode;
    }
}