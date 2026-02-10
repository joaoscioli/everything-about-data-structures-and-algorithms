package patterns.fast_slow_pointers.examples;

import java.util.HashSet;
import java.util.Set;

/// Linked List Loop
/// Given a singly linked list, determine if it contains a cycle. A cycle occurs if a node's next
/// pointer references an earlier node in the list, causing a loop.
///
/// Example:
/// ```text
/// 0 → 1 → 2 → 3 → 4 → 5
///         ↑           ↓
///         ← ← ← ← ← ← ←
/// ```
/// | Output: True
///
/// Bad approach:
/// ````java
/// public boolean hasCycle(ListNode head) {
///         Set<ListNode> visited = new HashSet<>();
///         ListNode current = head;
///
///         while (current != null) {
///             // Cycle detected if the current node has already been visited
///             if (visited.conains(current)) {
///                 return true;///             }
///             visited.add(current);
///              current.next;
///         }
///         return false;
///     }
/// ````
/// Best Approach:
/// This algorithm is formally known as the 'Floyd Loop Detection' algorithm.
/// **Complexity Analysis**
/// **Time complexity:** The time complexity of linked_list_loop is O(n) because the fast pointer will
/// meet the slow pointer in a linear number of steps, as described.
/// **Space complexity:** The space complexity is 0(1).
///
public class LinkedListLoop {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Check both 'fast' and 'fast.next' to avoid NullPointerException
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move one step
            fast = fast.next.next;      // move two steps

            if (slow == fast) {
                return true; // cycle detected
            }
        }

        return false; // no cycle
    }
}
