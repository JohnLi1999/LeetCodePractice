package utils.pair_node;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        Pair pair = (Pair) object;
        return this.getKey() == pair.getKey() && this.getValue() == pair.getKey();
    }

    @Override
    public String toString() {
        return "(" + getKey() + ", " + getValue() + ')';
    }
}
