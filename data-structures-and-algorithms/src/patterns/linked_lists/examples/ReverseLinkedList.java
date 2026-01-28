package patterns.linked_lists.examples;

/// Reverse Linked List
/// Given the head of a singly linked list, reverse the list and return the new head.
///
/// **Complexity Analysis**
/// **Time complexity:** The time complexity of linked_list_reversal is O(n), where n denotes the
/// length of the linked list This is because we perform constant-time pointer manipulation at each
/// node of the linked list
/// **Space complexity:** The space complexity is 0(1).
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
