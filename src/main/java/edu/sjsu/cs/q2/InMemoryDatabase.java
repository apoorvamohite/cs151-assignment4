package edu.sjsu.cs.q2;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Creates and provides an API to an In-Memory database(a key-value store) that stores Strings as keys and Integers as values.
 * TODO: Fix the following issues:
 * 1. When calling put() in parallel, the size of the map is not as expected. See code below for details.
 * 2. get() method returns -1 incorrectly sometimes.
 */
public class InMemoryDatabase {

    public static final int NUM_KEYS=1000;

    private static InMemoryDatabase instance = new InMemoryDatabase();

    private Map<String, Integer> map = new HashMap<>();

    public Integer get(String key) {
        return map.getOrDefault(key, -1);
    }

    public void put(String key, Integer value) {
        map.put(key, value);
    }

    public int getSize() {
        return map.size();
    }

    public static InMemoryDatabase getDatabaseHandle() {
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {

        InMemoryDatabase db = InMemoryDatabase.getDatabaseHandle();

        // Do NOT change the code below
        // The code below is adding NUM_KEYS number of keys to the in-memory database in parallel.
        // It is similar to
        // db.put("myKey0", 0)
        // db.put("myKey1", 1)
        // ...
        // db.put("myKey999", 999)
        IntStream.range(0,NUM_KEYS).parallel().forEach(i -> {
            db.put("myKey"+i, i);
        });

        // Sometimes the value corresponding to a key is -1
        // Expected value is equal to i
        IntStream.range(0,NUM_KEYS).parallel().forEach(i -> {
            System.out.println(db.get("myKey"+i));
        });

        // The size of the final map is sometimes not equal to NUM_KEYS
        // Expected size is NUM_KEYS
        System.out.println("Size: "+ db.getSize());
    }
}
