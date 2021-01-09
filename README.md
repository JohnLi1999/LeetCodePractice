# Common Use JAVA API

## Map
- `boolean containsKey(Object key)`
- `V get(Object key)`
- `default V  getOrDefault​(Object key, V defaultValue)`
- `V put(K key, V value)`
- `V remove(Object key)`
- `default V  replace(K key, V value)`
- `default boolean  replace(K key, V oldValue, V newValue)`
- `Set<K> keySet()`
- `boolean isEmpty()`
- `int size()`
- `static <K, V> Map<K, V>  of(K k1, V v1, K k2, V v2, K k3, V v3)`
    
## List
- `E get​(int index)`
- `void	add​(int index, E element)`
- `boolean add(E e)`
- `boolean addAll(Collection<? extends E> c)`
- `boolean contains(Object o)`
- `boolean isEmpty()`
- `int size()`
- `E set​(int index, E element)`
- `E remove(int index)`
- `boolean remove(Object o)`
- `static <E> List<E>  of(E e1, E e2, E e3)`

## Deque
- `boolean isEmpty()`
- `int size()`
- `boolean contains​(Object o)`

### Summary of Deque Methods
|         | First Element (Head) | First Element (Head) | Last Element (Tail) | Last Element (Tail) |
| ------- | -------------------- | -------------------- | ------------------- | ------------------- |
|         | Throw Exceptions     | Special Value        | Throw Exceptions    | Special Value       |
| Insert  | addFirst(e)          | offerFirst(e)        | addLast(e)          | offerLast(e)        |
| Remove  | removeFirst()        | pollFirst()          | removeLast()        | pollLast()          |
| Examine | getFirst()           | peekFirst()          | getLast()           | peekLast()          |

### Queue - LinkedList
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

### Stack - ArrayDeque
| Stack Methods    | Equivalent Deque Methods |
| ---------------- | ------------------------ |
| `void push(E e)` | `void addFirst(E e)`     |
| `E pop()`        | `E removeFirst()`        |
| `E peek()`       | `E getFirst()`           |

#### Both `LinkedList` and `ArrayDeque` can be used as a `Deque`

## PriorityQueue (Min-Heap by default)
- `PriorityQueue​(Collection<? extends E> c)`
- `boolean add​(E e)`
- `E remove()`
- `boolean offer​(E e)`
- `E peek()`
- `E poll()`
- `boolean contains​(Object o)`
- `int size()`

## Set
- `boolean add(E e)`
- `boolean contains(Object o)`
- `boolean isEmpty()`
- `boolean remove(Object o)`
- `void	clear()`
- `static <E> Set<E>  of(E e1, E e2, E e3)`

## String
- `int length()`
- `char charAt(int index)` 
- `int codePointAt​(int index)`

## StringBuilder
- `StringBuilder append​(String str)`
- `StringBuilder delete​(int start, int end)`
- `StringBuilder replace​(int start, int end, String str)` 
- `char charAt​(int index)`
- `int length()`
- `StringBuilder reverse()`
- `String toString()`

## Arrays
- `static <T> List<T>  asList(T... a)` 
- `static void  sort(Object[] a)`
- `static void  sort(int[] a)`
- `static <T> void  sort​(T[] a, Comparator<? super T> c)`
- `static void  fill​(int[] a, int val)`
    
## Integer
- `Integer.MAX_VALUE` = 2<sup>31</sup>-1 = 2147483647
- `Integer.MIN_VALUE` = -2<sup>31</sup> = -2147483648
- `String toString()`
- `static String  toString​(int i)`

## Collections
- `static <T> Comparator<T>  reverseOrder()`
- `static <T extends Object & Comparable<? super T>> T 
    max​(Collection<? extends T> coll)	`
    - Returns the maximum element of the given collection, according to the natural ordering of its elements.
- `static <T extends Object & Comparable<? super T>> T  
    min​(Collection<? extends T> coll)	`
    - Returns the minimum element of the given collection, according to the natural ordering of its elements.

## MATH
- `static int  abs(int a)`

## Character
- `char charValue()`
- `static int  getNumericValue​(char ch)`

## Comparator
- `static <T> Comparator<T>	 comparingInt​(ToIntFunction<? super T> keyExtractor)`
    - e.g. `Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));`
    
## TreeMap
-  `TreeMap​(Comparator<? super K> comparator)`
    - Constructs a new, empty tree map, ordered according to the given comparator.
- `K firstKey()`
    - Returns the first (lowest) key currently in this map.
