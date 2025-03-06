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
        HashMap<Node,Node> map=new HashMap<>();
        return func(node,map);
    }

    public Node func(Node node,HashMap<Node,Node> map){
        if(node==null) return null;
        Node newNode=new Node(node.val);
        map.put(node,newNode);

        for(Node neighbor : node.neighbors){
            if(!map.containsKey(neighbor)){
                newNode.neighbors.add(func(neighbor,map));
            }else{
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
}