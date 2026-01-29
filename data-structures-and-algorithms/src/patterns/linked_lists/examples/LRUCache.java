package patterns.linked_lists.examples;

/// # LRU Cache (Least Recently Used)
///
/// Design and implement a data structure for an LRU (Least Recently Used) cache.
/// The cache supports constant-time operations using:
///
/// - HashMap for O(1) key lookups
/// - Doubly Linked List to maintain usage order
///
/// ------------------------------------------------------------
/// SUPPORTED OPERATIONS
/// ------------------------------------------------------------
/// - LRUCache(int capacity)
///   Initializes the cache with a fixed capacity.
///
/// - int get(int key)
///   Returns the value associated with the key if it exists,
///   otherwise returns -1. Marks the key as most recently used.
///
/// - void put(int key, int value)
///   Inserts or updates a key-value pair. If the cache exceeds
///   capacity, the least recently used item is evicted.
///
/// ------------------------------------------------------------
/// CORE IDEA
/// ------------------------------------------------------------
/// The doubly linked list keeps track of usage order:
/// - Head  -> Least Recently Used (LRU)
/// - Tail  -> Most Recently Used (MRU)
///
/// Whenever a key is accessed or updated, its node is moved
/// to the tail of the list.
///
/// ------------------------------------------------------------
/// TIME & SPACE COMPLEXITY
/// ------------------------------------------------------------
/// get(): O(1)
/// put(): O(1)
/// Space Complexity: O(capacity)
///
/// ------------------------------------------------------------
/// IMPLEMENTATION
/// ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;

class DoublyLinkedListNode {
    int key;
    int value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private final int capacity;
    private final Map<Integer, DoublyLinkedListNode> cache;

    /// Dummy head (LRU side) and tail (MRU side)
    private final DoublyLinkedListNode head;
    private final DoublyLinkedListNode tail;

    /// Initializes the LRU Cache with a given capacity.
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        /// Initialize dummy nodes
        head = new DoublyLinkedListNode(-1, -1);
        tail = new DoublyLinkedListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /// Returns the value of the key if it exists in the cache.
    /// Marks the key as most recently used.
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        DoublyLinkedListNode node = cache.get(key);

        /// Move the accessed node to the tail (MRU position)
        removeNode(node);
        addToTail(node);

        return node.value;
    }

    /// Inserts or updates a key-value pair in the cache.
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            /// Remove the old node if key already exists
            removeNode(cache.get(key));
        }

        DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
        cache.put(key, node);
        addToTail(node);

        /// Evict LRU if capacity is exceeded
        if (cache.size() > capacity) {
            DoublyLinkedListNode lru = head.next;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }

    /// Removes a node from the doubly linked list.
    private void removeNode(DoublyLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /// Adds a node right before the tail (MRU position).
    private void addToTail(DoublyLinkedListNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    /// Example execution
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 100);
        cache.put(2, 250);
        System.out.println(cache.get(2)); // 250

        cache.put(4, 300);
        cache.put(3, 200);

        System.out.println(cache.get(4)); // 300
        System.out.println(cache.get(1)); // -1 (evicted)
    }
}
