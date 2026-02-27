# Sliding Window

Sliding Window is a **two-pointer technique** used to efficiently solve problems involving **subarrays**, **substrings**, or contiguous sequences.

Instead of recalculating results for every possible range (O(n²)), we "slide" a window across the data structure, maintaining relevant state dynamically — achieving **O(n)** time complexity in many cases.

This technique is fundamental for coding interviews and real-world performance-sensitive systems.

---

# Why Sliding Window Matters

In interviews, many brute-force solutions are O(n²).  
Sliding Window reduces them to **O(n)** by:

- Avoiding repeated computation
- Maintaining incremental state
- Expanding and shrinking boundaries intelligently

In production systems, this pattern appears in:

- Streaming systems
- Rate limiting
- Real-time analytics
- Memory-bounded processing
- Log aggregation
- Network packet inspection

---

# Core Idea

Maintain a window defined by two pointers:
```text
[left ........ right]
```

You move `right` to expand the window.  
You move `left` to shrink it when constraints are violated.

The trick is maintaining **invariant conditions** while sliding.

---

# Two Main Types

## 1 - Fixed-Size Sliding Window

Window size is constant.

Example problems:
- Maximum sum of subarray of size k
- Average of subarrays of size k

### Pattern

```java
int windowSum = 0;
int maxSum = 0;

for (int right = 0; right < arr.length; right++) {
    windowSum += arr[right];

    if (right >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[right - (k - 1)];
    }
}
```
Time Complexity: O(n)

Space Complexity: O(1)

---

## 2 - Variable-Size Sliding Window

Window size changes dynamically based on a condition.

Example problems:
- Longest substring without repeating characters
- Minimum size subarray sum
- Longest substring with at most K distinct characters

#### Pattern
````java
int left = 0;

for (int right = 0; right < s.length(); right++) {

    // expand window

    while (windowInvalid) {
        // shrink window
        left++;
    }

    // update result
}
````

---

## When To Use Sliding Window
Use when you see:
- Subarray
- Substring
- Contiguous elements
- "Longest"
- "Shortest"
- "Maximum"
- "Minimum"
- "At most K"
- "Exactly K"

If the problem involves contiguous ranges and optimization → think Sliding Window.

---

## Interview Mindset

When reading a problem:
1. Is it contiguous?
2. Can I reuse previous computation?
3. Can I maintain state while expanding?
4. What breaks the window condition?
5. What invariant must hold?

Senior engineers recognize patterns before writing code.

---

## Classic Interview Problems
- Maximum Subarray Sum of Size K
- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Fruit Into Baskets
- Longest Repeating Character Replacement
- Subarray Product Less Than K

---

## Common Mistakes
- Forgetting to shrink window properly
- Infinite loops in while
- Updating result in wrong place
- Not maintaining invariant correctly
- Using HashMap but not decrementing frequency
- Off-by-one errors

---

## Complexity

Most Sliding Window problems:
- Time: O(n)
- Space: O(1) or O(k) depending on auxiliary structures

Each element enters and leaves the window at most once.

---

## Senior-Level Insight

Sliding Window is not just an interview trick.

It is a state compression technique:
- Transforming quadratic brute force
- Maintaining minimal recomputation
- Managing bounded memory in streaming systems

It teaches you how to reason about:
- Invariants
- Boundaries
- State transitions
- Amortized analysis

If you master Sliding Window, you unlock a large class of problems.