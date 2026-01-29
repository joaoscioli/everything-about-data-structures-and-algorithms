# Linked Lists

## 📌 What is it?

A **Linked List** is a linear data structure where each element (node) contains:

* a **value**
* a **reference (pointer)** to the next node

Unlike arrays, elements are **not stored contiguously in memory**.

Core idea: efficient insertion/removal by manipulating pointers instead of shifting elements.

---

## 🎯 When to use

* Frequent insertions or deletions
* Unknown or dynamic size
* Problems involving pointer manipulation
* When array resizing or shifting is costly

---

## 🧩 Common Patterns

* **Traversal**
  Iterate through the list using a current pointer.

* **Fast & Slow Pointers**
  Use two pointers moving at different speeds.
  Classic for cycle detection, middle of list, and palindrome checks.

* **In-place Reversal**
  Reverse links without extra memory.

* **Dummy Node Technique**
  Simplifies edge cases (head removal, insertion).

---

## 📦 Singly vs Doubly Linked Lists

| Type   | Characteristics    |
| ------ | ------------------ |
| Singly | Node → next        |
| Doubly | Node → prev & next |

Most interview problems focus on **singly linked lists**.

---

## 📈 Time & Space Complexity

| Operation                  | Time |
| -------------------------- | ---- |
| Access                     | O(n) |
| Search                     | O(n) |
| Insert/Delete (given node) | O(1) |

Space: **O(n)**

---

## 🧪 Examples

| Example             | Description                   |
| ------------------- | ----------------------------- |
| Reverse Linked List | Reverse nodes in-place        |
| Detect Cycle        | Determine if list has a cycle |
| Find Middle         | Return middle node            |
| Merge Two Lists     | Merge two sorted linked lists |
| Remove Nth Node     | Remove nth node from end      |

---

## 🧠 Interview Tips

* Always draw the list (nodes + arrows)
* Watch for `null` pointer edge cases
* Dummy nodes reduce conditional logic
* Clarify if list is singly or doubly

### #Tip: Visualize pointer manipulations.
Often, it can be tricky to figure out exactly what to do when dealing with linked list manipulation. Drawing pointers as arrows between nodes can be quite helpful. By observing how these
arrows should be reoriented to represent changes in the linked list’s structure, we can deduce
the necessary pointer manipulation logic. This approach also helps identify which nodes we
need references to when making these changes.

### Tip: Explore how combining data structures can help achieve certain functionality.
It’s possible to encounter situations where no single data structure provides the functionality
required for your solution. In such cases, try to work out if this functionality can be achieved
using a combination of data structures. For instance, in this problem we combined a doubly *
linked list and a hash map to achieve the functionality required for the LRU cache.


---

## ⚠️ Common Pitfalls

* Losing reference to the rest of the list
* Incorrect pointer update order
* Forgetting to handle head changes

---

## 🚀 Key Takeaway

Linked List problems are about **pointer discipline**.
If you control the pointers, you control the problem.

---

> Study notes based on **"Coding Interview Patterns — Nail Your Next Coding Interview (2024) — Xu A"**, following the same structure used for Hash Maps and Sets.
