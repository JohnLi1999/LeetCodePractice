# Common Use JAVA API

## Map
- `boolean containsKey(Object key)`
- `V get(Object key)`
- `default V getOrDefault​(Object key, V defaultValue)`
- `V put(K key, V value)`
- `V remove(Object key)`
- `default V replace(K key, V value)`
- `default boolean replace(K key, V oldValue, V newValue)`
- `Set<K> keySet()`
- `boolean isEmpty()`
- `int size()`
- `static <K, V> Map<K, V>  of(K k1, V v1, K k2, V v2, K k3, V v3)`
    
## List
- `boolean add(E e)`
- `boolean addAll(Collection<? extends E> c)`
- `boolean contains(Object o)`
- `boolean isEmpty()`
- `int size()`
- `E remove(int index)`
- `boolean remove(Object o)`
- `static <E> List<E>  of(E e1, E e2, E e3)`

## Deque
- `boolean isEmpty()`
- `int size()`

### LinkedList
| Queue Methods        | Equivalent Deque Methods |
| -------------------- | ------------------------ |
| `boolean add(E e)`   | `void addLast(E e)`      |
| `boolean offer(E e)` | `boolean offerLast(E e)` |
| `E remove()`         | `E removeFirst()`        |
| `E poll()`           | `E pollFirst(E e)`       |
| `E element()`        | `E getFirst()`           |
| `E peek()`           | `E peekFirst()`          |

1. Methods `offer(E e)` and `offerLast(E e)` are preferable to `add(E e)` and `addLast(E e)`
2. Methods `E removeFirst()` and `E getFirst(E e)` throw `NoSuchElementException` error when the deque is empty 
3. Methods `E pollFirst(E e)` and `E peekFirst()` return `null` when the deque is empty 

### ArrayDeque
| Stack Methods    | Equivalent Deque Methods |
| ---------------- | ------------------------ |
| `void push(E e)` | `void addFirst(E e)`     |
| `E pop()`        | `E removeFirst()`        |
| `E peek()`       | `E getFirst()`           |


## Set
- `boolean add(E e)`
- `boolean contains(Object o)`
- `boolean isEmpty()`
- `boolean remove(Object o)`
- `static <E> Set<E>  of(E e1, E e2, E e3)`

## String
- `int length()`
- `char charAt(int index)` 

## Arrays
- `static <T> List<T>  asList(T... a)` 
- `static void  sort(Object[] a)`
- `static void  sort(int[] a)`

## MATH
- `static int  abs(int a)`
    
## Integer
- `Integer.MAX_VALUE` = 2<sup>31</sup>-1 = 2147483647
- `Integer.MIN_VALUE` = -2<sup>31</sup> = -2147483648

## Character
- `char charValue()`

