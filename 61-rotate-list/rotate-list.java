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
    public ListNode rotateRight(ListNode head, int k) {
        //if(k==0) return head;
        if(head==null || head.next==null) return head;
        int rotates=k%totLen(head);
        if(rotates==0) return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        int ind=0;

        while(ind!=rotates){
            fast=fast.next;
            ind++;
        }

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        ListNode newHead=slow.next;
        slow.next=null;
        fast.next=dummy.next;

        return newHead;
    }

    public int totLen(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
}