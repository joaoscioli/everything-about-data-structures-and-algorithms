package patterns.linked_lists.examples;
/// # Traversing Combined Linked Lists
///
/// This project demonstrates how to traverse **combined linked lists** using
/// pointer-based techniques.
///
/// A *combined linked list* scenario happens when two linked lists:
/// - Share a common tail (intersection)
/// - Are logically merged for traversal or comparison
///
/// This pattern is very common in:
/// - Technical interviews
/// - Memory reference problems
/// - Graph-to-list reductions
///
/// ------------------------------------------------------------
/// CONCEPT OVERVIEW
/// ------------------------------------------------------------
/// Given two singly linked lists:
///
/// List A: A1 → A2 → A3
/// ↘
/// C1 → C2 → C3
/// ↗
/// List B: B1 → B2 ------
///
/// The goal is to **traverse both lists efficiently** and optionally:
/// - Detect the intersection
/// - Traverse the shared nodes only once
/// - Keep O(1) space complexity
///
/// ------------------------------------------------------------
/// CORE IDEA (Two-Pointer Traversal)
/// ------------------------------------------------------------
/// 1. Use two pointers, one starting at each list head
/// 2. Traverse normally
/// 3. When a pointer reaches the end, redirect it to the other list's head
/// 4. If the lists intersect, the pointers will meet at the shared node
///
/// This works because both pointers traverse the same total length
/// (A + C + B or B + C + A).
///
/// ------------------------------------------------------------
/// TIME & SPACE COMPLEXITY
/// ------------------------------------------------------------
/// Time Complexity: O(n + m)
/// Space Complexity: O(1)
///
/// ------------------------------------------------------------
/// IMPLEMENTATION
/// ------------------------------------------------------------
public class TraversingCombinedLinkedLists {
    // Finds the intersection node of two combined linked lists.
    public static ListNode findIntersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }


        ListNode pointerA = headA;
        ListNode pointerB = headB;


        // Traverse both lists until the pointers meet
        while (pointerA != pointerB) {
            // Move to the next node or switch lists at the end
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }


    // Either both are null (no intersection)
    // or both point to the intersection node
        return pointerA;
    }


    /// Example traversal that prints all nodes from both lists
    /// without duplicating the shared tail.
    ///
    /// @param headA head of the first list
    /// @param headB head of the second list
    public static void traverseCombined(ListNode headA, ListNode headB) {
        ListNode intersection = findIntersection(headA, headB);


        // Traverse list A until the intersection
        ListNode current = headA;
        while (current != intersection) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }


        // Traverse list B until the intersection
        current = headB;
        while (current != intersection) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }


        // Traverse the shared tail once
        while (intersection != null) {
            System.out.print(intersection.val + " -> ");
            intersection = intersection.next;
        }


        System.out.println("null");
    }


    // Demo execution
    public static void main(String[] args) {
        // Shared tail
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(10);
        c1.next = c2;


        // List A
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(7);
        a1.next = a2;
        a2.next = c1;

        // List B
        ListNode b1 = new ListNode(99);
        b1.next = c1;

        traverseCombined(a1, b1);
    }
}
