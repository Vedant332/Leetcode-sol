class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while (temp != null) {
            ListNode kthNode = findKth(temp, k);
            if (kthNode == null) {
                if (prevNode != null) prevNode.next = temp;
                break;
            }

            nextNode = kthNode.next;  
            kthNode.next = null;      

            ListNode newHead = rev(temp);  

            if (temp == head) {
                head = newHead;  
            } else {
                prevNode.next = newHead;  
            }

            temp.next = nextNode;  
            prevNode = temp;       
            temp = nextNode;       
        }

        return head;
    }

    private ListNode findKth(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }

    private ListNode rev(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;  
    }
}