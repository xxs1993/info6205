/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.hashtable;

public class FrequencyCounter<K> {

    public FrequencyCounter(ST<K, Integer> map) {
        this.map = map;
    }

    public FrequencyCounter() {
        this(new STMap<>());
    }

    public int get(Object key) {
        //noinspection unchecked
        Integer value = map.get((K) key);
        if (value == null) value = 0;
        return value;
    }

    public void increment(K s) {
        // TODO implement me
    }

    public String toString() {
        return map.toString();
    }

    private final ST<K, Integer> map;

    public static void main(String[] args) {
        FrequencyCounter<String> counter = new FrequencyCounter<>();

        for (String arg : args) counter.increment(arg);

        System.out.println(counter.toString());
    }
}
