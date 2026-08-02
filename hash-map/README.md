# Hash Map / Frequency Counting

Hash maps are one of the most useful tools for reducing repeated work in algorithm problems.

## Core idea

Store information that has already been seen so future lookups can be performed in average O(1) time.

Typical uses:

- frequency counting
- complement lookup
- duplicate detection
- grouping values by a computed key
- prefix sum lookup

## Complexity

For a hash-based map, insertion and lookup are usually O(1) on average, with O(n) extra space in many common interview problems.

## Examples in this folder

1. `TwoSum.java` — complement lookup
2. `ContainsDuplicate.java` — duplicate detection
3. `ValidAnagram.java` — character frequency counting
4. `FirstUniqueCharacter.java` — frequency map + second pass
5. `SubarraySumEqualsK.java` — prefix sum + frequency map
