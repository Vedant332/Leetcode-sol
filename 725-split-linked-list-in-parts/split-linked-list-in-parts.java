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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size=getSize(head);
        int[] arr=getArray(size,k);
        ListNode[] ans=new ListNode[k];
        ListNode newNode=head;
        for(int i=0;i<k;i++){
            ans[i] = newNode;
            int nodeCount=arr[i];
            ListNode prev=null;
            ListNode curr=newNode;

            while(nodeCount>0){
                prev=curr;
                curr=curr.next;
                nodeCount--;
            }
            newNode=curr;
            if(prev!=null){
                prev.next=null;
            }
        }
        return ans;
    }

    public int getSize(ListNode head){
        ListNode dummy=head;
        int size=0;

        while(dummy!=null){
            dummy=dummy.next;
            size++;
        }
        return size;
    }

    public int[] getArray(int size, int k){
        int[] arr=new int[k];
        int parts=size/k;
        int extraParts=size%k;

        for(int i=0;i<k;i++){
            arr[i]=parts;
            if(extraParts>0){
                arr[i]=arr[i]+1;
                extraParts--;
            }
        }
        return arr;
    } 
}