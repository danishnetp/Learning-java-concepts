package com.learning.concepts.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo1 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);

        System.out.println(hashMap);

        for(Map.Entry<String, Integer> map : hashMap.entrySet()){
            System.out.println("Key: " + map.getKey() + ", Value: " + map.getValue());
        }

        hashMap.putIfAbsent("Two", 22); // Will not update as "Two" already exists
        System.out.println("After putIfAbsent: " + hashMap);
    }
}
