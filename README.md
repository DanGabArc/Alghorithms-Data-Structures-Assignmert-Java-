# Minimal Collections

> Custom data structures in pure Java. No `java.util.*` — just algorithms and understanding.

Minimal Collections is a learning-focused library that implements fundamental data structures from scratch. Every collection is built on primitive arrays or manual node references, giving you full visibility into behaviour and operation complexity.

---

## Problem: the hidden magic of the standard library

Developers grow accustomed to reaching for `ArrayList`, `LinkedList`, and `PriorityQueue` from `java.util` without ever thinking about how they work under the hood.

- **Lost intuition.** Using ready-made collections without understanding their internals leads to poor structure choices for a given problem.
- **Hard to customise.** Standard collections are difficult to adapt to specific requirements — such as constrained memory or a non-standard traversal order.
- **Shallow interview knowledge.** Questions like "How do doubly-linked list methods actually work?" stump anyone who has only ever called the ready-made ones.

## Solution: the "write it yourself" approach

Minimal Collections forces you to look under the hood by implementing every structure by hand. This is not a replacement for `java.util` — it is a **living textbook** that demonstrates:

- the mechanics of dynamic array growth in `MyArrayList`;
- how a doubly-linked list works and how to avoid memory leaks in `MyLinkedList`;
- building `Stack` and `Queue` on top of existing primitives;
- implementing a binary min-heap (`MinHeap`) with sift-up and sift-down.

Each structure implements the shared `MyList<T>` interface or exposes a minimal specialised API — completely independent of `java.util`.

---

## Project structure

```
src/
├── MyList.java        # Base list interface
├── MyArrayList.java   # Dynamic array (auto-grows ×2)
├── MyLinkedList.java  # Doubly-linked list (Node head/tail)
├── MyStack.java       # LIFO stack (backed by MyLinkedList)
├── MyQueue.java       # FIFO queue (backed by MyLinkedList)
└── MyMinHeap.java     # Min-heap (backed by MyArrayList)
```

---

## Quick start

Copy all `.java` files into your project — no external dependencies required.

```bash
javac src/*.java
java Main
```

---

## Usage examples

### Dynamic list — `MyArrayList` and `MyLinkedList`

```java
MyList<String> list = new MyArrayList<>();   // or new MyLinkedList<>()
list.add("Java");
list.add("Kotlin");
list.add(1, "Scala");           // insert at index

System.out.println(list.get(1));    // Scala
System.out.println(list.remove(0)); // Java
System.out.println(list.size());    // 2
```

### Stack — `MyStack`

```java
MyStack<Integer> stack = new MyStack<>();
stack.push(10);
stack.push(20);

System.out.println(stack.pop());  // 20
System.out.println(stack.peek()); // 10
System.out.println(stack.size()); // 1
```

### Queue — `MyQueue`

```java
MyQueue<String> queue = new MyQueue<>();
queue.enqueue("first");
queue.enqueue("second");

System.out.println(queue.dequeue()); // first
System.out.println(queue.dequeue()); // second
System.out.println(queue.isEmpty()); // true
```

### Min-heap — `MyMinHeap`

```java
MyMinHeap<Integer> heap = new MyMinHeap<>();
heap.add(42);
heap.add(15);
heap.add(7);

System.out.println(heap.peek());      // 7
System.out.println(heap.removeMin()); // 7
System.out.println(heap.removeMin()); // 15
```

---

## Technical details

| Class | Internal structure | Operation complexity |
|---|---|---|
| `MyArrayList` | `Object[]`, capacity doubles when full | `get` O(1), `add` at end O(1) amortised, `add` at index O(n) |
| `MyLinkedList` | Doubly-linked `Node<T>` (head/tail) | `add` at head/tail O(1), `get` O(n), `remove` at index O(n) |
| `MyStack` | Adapter over `MyLinkedList` (LIFO) | `push` / `pop` / `peek` O(1) |
| `MyQueue` | Adapter over `MyLinkedList` (FIFO) | `enqueue` / `dequeue` O(1) |
| `MyMinHeap` | Binary heap backed by `MyArrayList` | `add` / `removeMin` O(log n), `peek` O(1) |

---

## Requirements

- **JDK:** 8 or higher
- **Dependencies:** none (only the standard `java.lang` package)

---

## Testing

The project does not include an external test framework. For a quick sanity check, create a simple main class:

```java
public class TestCollections {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println("Size: "    + list.size());      // 2
        System.out.println("Removed: " + list.remove(0));   // 1
        System.out.println("Empty: "   + list.isEmpty());   // false
    }
}
```

For automated testing, connecting **JUnit 5** is recommended.
