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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left == right) return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        for(int i=0;i<left-1;i++){
            prev=prev.next;
        }

        ListNode start=prev.next;
        ListNode end=start;

        for(int i=left;i<right;i++){
            end=end.next;
        }
        ListNode temp=end.next;
        end.next=null;

        prev.next=rev(start);
        start.next=temp;

        return dummy.next;
    }

    public ListNode rev(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}