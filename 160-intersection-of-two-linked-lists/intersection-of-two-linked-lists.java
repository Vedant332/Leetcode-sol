/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pta=headA;
        ListNode ptb=headB;

        while(pta!=ptb){
            if(pta==null){
                pta=headB;
            }else{
                pta=pta.next;
            }
            if(ptb==null){
                ptb=headA;
            }else{
                ptb=ptb.next;
            }
        }
        return ptb;
    }
}