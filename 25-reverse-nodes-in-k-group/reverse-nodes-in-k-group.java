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

            nextNode = kthNode.next;  // Store the next segment
            kthNode.next = null;      // Disconnect the segment to reverse

            ListNode newHead = rev(temp);  // Reverse the segment

            if (temp == head) {
                head = newHead;  // Update head for the first segment
            } else {
                prevNode.next = newHead;  // Connect previous reversed segment
            }

            temp.next = nextNode;  // Link last node of reversed segment to next part
            prevNode = temp;       // Update previous node for next iteration
            temp = nextNode;       // Move temp forward
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

        return prev;  // New head of reversed segment
    }
}