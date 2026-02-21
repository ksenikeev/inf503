package ru.itis.inf503.lab2_2;

public interface Map503<K, V> {

    interface Entry<K, V> {
        K getKey();
        V getValue();
    }

    void put(K key, V value);
    V get(K key);
    int size();
    V remove(K key);
    void clear();
    Set503gen<Entry<K, V>> entrySet();
    Set503gen<K> keySet();
    List503<V> values();
}
