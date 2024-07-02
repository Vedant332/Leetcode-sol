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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode f=null;
       for(int i=1;i<k;i++){
        fast=fast.next;
       } 
        f=fast;

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        int temp=f.val;
        f.val=slow.val;
        slow.val=temp;

        return head;

    }
}