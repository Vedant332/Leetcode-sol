/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head==null) return null;

        head=reverse(head);
        ListNode curr=head;
        ListNode prev=null;
        int max=-100;

        while(curr!=null){
            if(curr.val<max){
                prev.next=curr.next;
            }else{
                max=curr.val;
                prev=curr;
            }
            curr=curr.next;
        }
        return reverse(head);
    }

    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode fwd=head;;
        while(curr!=null){
            fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        return prev;
    }
}