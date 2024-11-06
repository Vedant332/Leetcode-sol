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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((x,y)->x.val-y.val);

        for(ListNode it : lists){
            while(it!=null){
                pq.add(it);
                it=it.next;
            }
        }

        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        while(!pq.isEmpty()){
            temp.next=pq.poll();
            temp=temp.next;
        }
        temp.next=null;

        return dummy.next;
    }
}