/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       Node temp=head;

       while(temp!=null){
        Node currNode=new Node(temp.val);
        currNode.next=temp.next;
        temp.next=currNode;
        temp=temp.next.next;
       }

       temp=head;
       while(temp!=null){
        Node currNode=temp.next;
        if(temp.random!=null){
            temp.next.random=temp.random.next;
        }else{
            temp.next.random=null;
        }
        temp=temp.next.next;
       }

       Node dummyNode=new Node(0);
       Node res=dummyNode;
       temp=head;

       while(temp!=null){
        res.next=temp.next;
        temp.next=temp.next.next;
        temp=temp.next;
        res=res.next;
       }

       return dummyNode.next;

    }
}