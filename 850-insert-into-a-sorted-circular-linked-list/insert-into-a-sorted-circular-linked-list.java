/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node ls=new Node(insertVal,null);
        if(head==null){
            ls.next=ls;
            return ls;
        }

        Node curr=head.next;
        Node prev=head;
        while(curr!=head){
            if(prev.val<=insertVal && insertVal<=curr.val) break;

            if(prev.val>curr.val){
                if(insertVal>=prev.val || insertVal<=curr.val) break;
            }
            prev=prev.next;
            curr=curr.next;
        }
        Node newNode=new Node(insertVal,prev.next);
        prev.next=newNode;
        return head;
    }
}