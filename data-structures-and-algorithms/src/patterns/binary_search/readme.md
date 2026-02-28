Perfeito — mantendo o padrão didático do projeto.

Segue o `README.md` em inglês:

---

````md
# 🔎 Binary Search

## 📌 What is Binary Search?

**Binary Search** is an efficient algorithm used to find an element in a **sorted** collection.

The core idea is simple:

> Instead of checking elements one by one, we repeatedly divide the search space in half.

This drastically reduces execution time.

---

## 🧠 Intuition

Imagine you're looking for a word in a dictionary.

You:
1. Open it in the middle
2. Decide whether the word is before or after
3. Repeat the process on the correct half

That’s **Binary Search**.

---

## ⏱ Time & Space Complexity

| Case        | Complexity |
|------------|------------|
| Best case  | O(1) |
| Average    | O(log n) |
| Worst case | O(log n) |
| Space      | O(1) (iterative) |

At every step, we cut the problem size in half.

---

## 📋 Requirement

⚠️ The array **MUST be sorted**.

If it is not sorted, Binary Search will not work correctly.

---

## 🧩 Algorithm (Step by Step)

1. Set `left = 0`
2. Set `right = n - 1`
3. While `left <= right`:
   - Compute `mid`
   - If `nums[mid] == target` → return index
   - If `nums[mid] < target` → search right half
   - If `nums[mid] > target` → search left half

---

## 💻 Java Implementation (Iterative)

```java
public int binarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2; // prevents overflow

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1; // not found
}
````

---

## ⚠️ Why Do We Use:

```java
int mid = left + (right - left) / 2;
```

Instead of:

```java
int mid = (left + right) / 2;
```

To prevent **integer overflow** when `left + right` exceeds the `int` limit.

---

## 🧮 Visual Example

Array:

```
[1, 3, 5, 7, 9, 11, 13]
```

Searching for `7`:

1. mid = 3 → value = 7 ✅ found

Searching for `11`:

1. mid = 3 → 7 < 11 → go right
2. mid = 5 → 11 ✅ found

---

## 🆚 Comparison with Linear Search

| Algorithm     | Complexity |
| ------------- | ---------- |
| Linear Search | O(n)       |
| Binary Search | O(log n)   |

For large arrays, the difference is massive.

Example:

* 1,000,000 elements
* Linear Search → up to 1,000,000 steps
* Binary Search → ~20 steps

---

## 🔁 Recursive Version (Optional)

```java
public int binarySearch(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
}

private int search(int[] nums, int target, int left, int right) {
    if (left > right) return -1;

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) return mid;

    if (nums[mid] < target) {
        return search(nums, target, mid + 1, right);
    } else {
        return search(nums, target, left, mid - 1);
    }
}
```

Space complexity: O(log n) due to recursion stack.

---

## 🎯 When Should You Use Binary Search?

Use Binary Search when:

* The array is sorted
* You need efficient search
* The problem asks to minimize search time
* Common patterns:

    * First / last occurrence
    * Lower bound / upper bound
    * Search in rotated array
    * Binary Search on Answer (minimum value satisfying a condition)

---

## 🚀 Key Takeaway

Binary Search is one of the most important algorithms for interviews.

If the data is sorted and you're thinking about optimization —
**Binary Search should be your first thought.**

```

---

If you want, next we can:

- Add a **Binary Search Patterns section** (more advanced)
- Add a **Common Mistakes section**
- Or start with the **first practical exercise** 👀
```
