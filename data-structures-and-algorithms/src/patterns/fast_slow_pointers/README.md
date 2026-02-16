# Fast and Slow Pointers (Two Pointers Technique)

## Overview

The **Fast and Slow Pointers** technique (also known as the **Tortoise and Hare** algorithm) is a common pattern used to solve problems involving linear data structures by traversing them with two pointers moving at different speeds.

Typically:

* **Slow pointer** moves one step at a time
* **Fast pointer** moves two steps at a time

This difference in speed allows us to detect cycles, find middle elements, and solve problems efficiently with **O(1) extra space**.

---

## When to Use This Technique

Use Fast and Slow Pointers when a problem involves:

* Detecting **cycles** in a linked list
* Finding the **middle** of a linked list
* Checking if a linked list is a **palindrome**
* Identifying **duplicate values** without extra memory
* Problems requiring **constant space** solutions

If the problem hints at *"meeting points"*, *"cycles"*, or *"middle traversal"*, this technique is a strong candidate.

---

## Core Intuition

Imagine two runners on a circular track:

* One runs fast 🏃‍♂️
* The other runs slow 🚶‍♂️

If the track has a loop, the faster runner will eventually catch up to the slower one.

This intuition applies directly to linked lists and arrays with cycles.

---

## Common Use Cases

### 1. Find the Middle of a Linked List

When the fast pointer reaches the end, the slow pointer will be at the middle.

````java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

return slow; // middle node
````

---

### 2. Detect a Cycle in a Linked List (Floyd’s Algorithm)

If a cycle exists, fast and slow pointers will meet.

````java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        return true; // cycle detected
    }
}

return false;
````

---

### 3. Find the Start of a Cycle

After detecting a cycle:

1. Move one pointer back to the head
2. Move both one step at a time
3. The meeting point is the cycle start

---

### 4. Palindrome Linked List

Steps:

1. Find the middle using fast & slow pointers
2. Reverse the second half
3. Compare both halves

---

### 5. Fast & Slow in Arrays

Used in problems like **Find the Duplicate Number**, where:

* Array values represent indices
* A cycle is formed implicitly

---

## Complexity

| Metric           | Value |
| ---------------- | ----- |
| Time Complexity  | O(n)  |
| Space Complexity | O(1)  |

---

## Common Mistakes

* Forgetting to check `fast != null && fast.next != null`
* Moving pointers in the wrong order
* Using extra memory when not needed
* Missing edge cases (empty list, single node)

---

## Practice Problems

* Linked List Cycle
* Middle of the Linked List
* Palindrome Linked List
* Find the Duplicate Number
* Circular Array Loop

---

## Related Patterns

* Two Pointers
* Sliding Window
* Linked List Manipulation

---

## Interview Tips:

#### Tip: Be prepared to address potential gaps in the information provided.
During an interview, it's possible the interviewer won't specify which middle node should be
returned for linked lists of even length. leaving it up to you to recognize and address this special
scenario. You might be expected to identify ambiguities like this and actively engage with the
interviewer to discuss a suitable resolution.

#### Tip: Visualize the problem.
At first glance, this problem seems like it requires mathematical reasoning to solve. However, ]
when we visualized the problem, we were able to formulate a solution using an algorithm j
we already know (Floyd's Cycle Detection). Visualizing a problem can help uncover hidden
patterns or data structures that can lead to the solution.

---
## Final Notes

Fast and Slow Pointers is a **foundational algorithmic pattern**. Mastering it improves your ability to recognize deeper problem structures and write optimized solutions with clean logic.

> If two pointers move at different speeds, something interesting is about to happen.
