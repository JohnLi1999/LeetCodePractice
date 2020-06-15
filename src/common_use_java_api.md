# Common Use JAVA API

## Map
- `boolean containsKey(Object key)`
- `V get(Object key)`
- `V put(K key, V value)`
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
### Stack Methods - ArrayDeque
- `void push(E e)`
- `E pop()`
- `E peek()`

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
- `Integer.MAX_VALUE` = 2<sup>31</sup>-1
- `Integer.MIN_VALUE` = -2<sup>31</sup>

## Character
- `char charValue()`

