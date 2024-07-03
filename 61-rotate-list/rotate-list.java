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
        if( head==null || head.next==null || k==0 ) return head;
        

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        ListNode slow=dummy ;
        int len=0;
        int ind=0;
        while(curr.next!=null){
            curr=curr.next;
            len++;
        }
        curr=dummy;
        if(k>len) k=k%len;
        if(k%len==0) return dummy.next;

        while(ind<k){
            curr=curr.next;
            ind++;
        }

        while(curr.next!=null){
            curr=curr.next;
            slow=slow.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        curr.next=dummy.next;

        return temp;

    }
}