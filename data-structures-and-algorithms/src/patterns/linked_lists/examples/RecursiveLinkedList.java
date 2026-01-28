package patterns.linked_lists.examples;

/// Reverse Linked List — Recursive Approach
///
/// This recursive solution reverses a linked list by solving
/// smaller instances of the same problem.
///
/// The base case is when the list has 0 or 1 node, which is
/// already reversed.
///
/// Each recursive call reverses the sublist starting at
/// head.next. Then, the next node is linked back to the
/// current node, and head.next is set to null to avoid cycles.
///
/// The function returns the new head of the reversed list.
///
/// **Complexity Analysis**
/// **Time complexity:** The time complexity of the recursive approach is O(n) because it involves a single
/// recursive traversal through the linked list visiting each node exactly once.
/// **Space complexity:** The space complexity is O(n) due to the stack space taken up by the recursive
/// call stack, which can grown levels deep because n recursive calls are made.
class RecursiveLinkedList {

    public ListNode reverseList(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the sublist starting at head.next
        ListNode newHead = reverseList(head.next);

        // Reverse the current node
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}

