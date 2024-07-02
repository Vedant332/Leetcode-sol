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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        int sum=0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow=rev(slow);
        fast=head;

        while(slow!=null){
            int ans=fast.val+slow.val;
            sum=Math.max(ans,sum);
            slow=slow.next;
            fast=fast.next;
        }
        return sum;

    }

    public ListNode rev(ListNode head){
        ListNode curr=head;
        ListNode fwd=head;
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