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
    public void reorderList(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode revList=rev(temp);
        ListNode temp1=head;
        ListNode temp2;
        while(temp1!=null && revList!=null){
            temp2=temp1.next;
            temp1.next=revList;
            temp1=revList;
            revList=temp2;
        }

    }
    public ListNode rev(ListNode temp){
        ListNode curr=temp;
        ListNode fwd=null;
        ListNode prev=null;

        while(curr!=null){
            fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        return prev;
    }
}