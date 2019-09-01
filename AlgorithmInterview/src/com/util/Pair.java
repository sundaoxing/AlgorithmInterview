package com.util;

public class Pair<K extends Comparable<K>,V> implements Comparable<Pair<K,V>>{
    public K k;
    public V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public int compareTo(Pair pair) {
        return k.compareTo((K) pair.k);
    }
}
