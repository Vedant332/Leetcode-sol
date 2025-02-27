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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode greater=new ListNode(0);
        ListNode sPointer=small;
        ListNode gPointer=greater;

        while(head!=null){
            if(head.val<x){
                sPointer.next=head;
                sPointer=sPointer.next;
            }else{
                gPointer.next=head;
                gPointer=gPointer.next;
            }
            head=head.next;
        }
        gPointer.next=null;
        sPointer.next=greater.next;

        return small.next;
    }
}