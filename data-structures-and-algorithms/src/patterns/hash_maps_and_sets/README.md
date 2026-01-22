# Hash Maps and Sets

## 📌 What is it?

Hash Maps and Sets are data structures based on **hashing**, allowing fast access, insertion, and deletion of elements.
They reduce time complexity of many problems from **O(n)** to **O(1) (average case)** by trading space for speed.

Core structures:

* **Hash Map** → stores key–value pairs
* **Hash Set** → stores unique values only

---

## 🎯 When to use

* Fast lookup is required
* Counting frequency of elements
* Checking existence or duplicates
* Mapping values to indices or metadata

---

## 🧩 Common Patterns

* **Frequency Counter**
  Count occurrences of elements (chars, numbers, words).

* **Existence Check**
  Track visited or seen elements.

* **Index Mapping**
  Store indices to avoid nested loops (e.g., Two Sum).

* **Deduplication**
  Remove or detect duplicates efficiently.

---

## 📦 HashMap vs HashSet

| Use case                | Structure |
| ----------------------- | --------- |
| Key → Value association | HashMap   |
| Count frequency         | HashMap   |
| Check if element exists | HashSet   |
| Remove duplicates       | HashSet   |

---

## 📈 Time & Space Complexity

| Structure | Time (avg) | Space |
| --------- | ---------- | ----- |
| HashMap   | O(1)       | O(n)  |
| HashSet   | O(1)       | O(n)  |

Worst case: O(n) due to collisions (rare in practice).

---

## 🧪 Examples

| Example                | Description                           |
| ---------------------- | ------------------------------------- |
| Two Sum                | Find two numbers that sum to a target |
| Contains Duplicate     | Check if array has duplicates         |
| First Unique Character | Find first non-repeating character    |
| Group Anagrams         | Group strings by character frequency  |
| Frequency Counter      | Count occurrences of elements         |

---

## 🧠 Interview Tips

* Ask if order matters (HashMap ≠ LinkedHashMap)
* Clarify if duplicates are allowed
* Remember: HashSet is ideal for existence checks
* In Java, `equals()` and `hashCode()` must be consistent

#### Tip: Iterate through solutions.
Don’t alwaysjump straight to the most optimal or clever solution, as this won’t give the interviewer much insight into your problem-solving process. Consider multiple approaches, starting with the more straightforward ones, and gradually refine them. This way, you demonstrate
your thought process and how you arrive at a more optimal solution.
