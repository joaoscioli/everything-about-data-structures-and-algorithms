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

#### Tip 01: Clarify problem constraints.
It’s common to not receive all the details of a problem from an interviewer. For example, you ' might only be asked to "check if a string is a palindrome.” 
But before diving into a solution, it’s 1 important to clarify details with the interviewer, such as the presence of non-alphanumeric j characters, their treatment, 
the role of numbers, the case sensitivity of letters, and other rele- ; vant details.

#### Tip 02: Confirm before using significant in-built functions.
This problem is made easier by using in-built functions such as .isalnum (or equivalent). Before using an 
in-built function that simplifies the implementation, ask the interviewer if it’s okay to use it, or if they would prefer you implement it yourself. The interviewer 
will most likely allow the use of an in-built function, or ask you to implement it as an exercise for later in the interview. If you use an in-built function, make 
sure you understand its time and space complexity. Remember that interviewers are looking for team players, and this shows them you're considerate of their preferences 
and can adapt your approach based on the requirements.