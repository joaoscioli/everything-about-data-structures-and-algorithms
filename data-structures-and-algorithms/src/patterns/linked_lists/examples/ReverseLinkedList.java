package patterns.linked_lists.examples;

/// Reverse Linked List
/// Given the head of a singly linked list, reverse the list and return the new head.
///
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // store next
            curr.next = prev; // reverse pointer
            prev = curr; // move prev forward
            curr = nextTemp; // move curr forward
        }
        return prev;
    }

    public ListNode reverseListWithStack(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListWithStack(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
