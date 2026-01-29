package patterns.linked_lists.examples;

/// Remove the K^th Last Node From a Linked List
/// Return the head of a singly linked list after removing the kth node from the end of it.
/// Example:
/// ```java
/// k = 2
/// (1)->(2)->(4)->(7)->(3)
/// to
/// (1)->(2)->(4)->->(3)
/// Constraints:
/// - The linked list contains at least one node.
/// ```
///
/// **Complexity Analysis**
/// **Time complexity:** The time complexity of remove_kth_last_node is O(ri). This is because the
/// algorithm first traverses at most n nodes of the linked list, and then two pointers traverse the
/// linked list at most once each.
/// **Space complexity:** The space complexity is 0(1).
///
public class RemoveTheKLastNode {
    public ListNode removeKthLastNode(ListNode head, int k) {
        // Dummy node to handle edge cases (like removing the head)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode leader = dummy;
        ListNode trailer = dummy;

        // Advance leader k steps ahead
        for (int i = 0; i < k; i++) {
            leader = leader.next;
            // If k is larger than the length of the list
            if (leader == null) {
                return head;
            }
        }

        // Move both pointers until leader reaches the last node
        while (leader.next != null) {
            leader = leader.next;
            trailer = trailer.next;
        }

        // Remove the k-th node from the end
        trailer.next = trailer.next.next;

        return dummy.next;
    }
}
