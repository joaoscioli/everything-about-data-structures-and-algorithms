# Two Pointers

## 📌 What is it?
Two Pointers is a technique where two indices traverse a data structure
from different positions to reduce time complexity from O(n²) to O(n).
Core Traversal Types

- **Inward Traversal**
Pointers start at opposite ends and move toward the center.
Ideal for sorted arrays, symmetry checks, and optimization problems (e.g., pair sums, palindromes, max area).

- **Unidirectional Traversal**
Both pointers move forward, each with a distinct responsibility (read vs write).
Commonly used for in-place filtering, reordering, and compaction.

- **Staged Traversal**
Pointer movement occurs in clearly defined phases.
Useful for problems involving next permutations or lexicographical transitions.
---

## 🎯 When to use
- Sorted arrays
- Problems involving pairs
- Palindrome checks
- Removing duplicates
- Partitioning problems

---

## 🧩 Common Variations
- Left & Right pointers
- Slow & Fast pointers
- Same direction traversal
- Opposite direction traversal

---

## 📈 Time & Space Complexity
- Time: O(n)
- Space: O(1)

---

## 🧪 Examples
| Example           | Description |
|-------------------|------------|
| PairSum           |Given an array of integers sorted in ascending order and a target value|
| TripletSum        |Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0.|
| IsPalindromeValid |Given a string, determine if it’s a palindrome after removing all non-alphanumeric characters|
| two_sum_sorted    |Find two numbers that sum to target |
| reverse_string    |Reverse a string in-place |
| remove_duplicates |Remove duplicates from sorted array |

---

## 🧠 Interview Tips
- Always check if the array is sorted
- Ask if extra space is allowed
- Be careful with pointer movement conditions
