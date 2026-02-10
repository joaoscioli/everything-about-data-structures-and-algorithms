package patterns.fast_slow_pointers.examples;

/// Linked List Midpoint
/// Given a singly linked list, find and return its middle node. If there are two middle nodes
/// return the second one.
///
/// Example 01:
/// ````text
///           mid
/// 1 -> 2 -> (4) -> 7 -> 3
/// ````
/// Output: Node 4
///
/// Example 02:
/// ````text
///           mid
/// 1 -> 2 -> (4) -> 7
/// ````
/// Output: Node 4
///
/// Constraints:
/// - The linked list contains at least one node.
/// - The linked list contains unique values.
///
/// **Complexity Analysis**
/// **Time complexity:** The time complexity of llnked_list_midpoint isO(n) because we traverse the
/// linked list linearly using two pointers.
/// **Space complexity:** The space complexity is 0(1).
///
public class LinkedListMidpoint {
    public ListNode findMidpoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // When the fast pointer reaches the end,
        // the slow pointer will be at the midpoint
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move one step
            fast = fast.next.next;     // move two steps
        }

        return slow; // midpoint node
    }
}
