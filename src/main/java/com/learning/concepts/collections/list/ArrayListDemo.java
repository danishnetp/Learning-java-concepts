package com.learning.concepts.collections.list;

import java.util.*;

/**
 * ArrayListDemo — demonstrates key ArrayList behaviors covered in interview Q&A:
 *
 *  1.  Basic add / get / remove
 *  2.  Internal growth (initial capacity 10, ~1.5× resize)
 *  3.  ensureCapacity() and trimToSize()
 *  4.  O(n) insert / remove in the middle vs O(1) at the end
 *  5.  Sorting with Comparator
 *  6.  Converting to array
 *  7.  Null elements
 *  8.  subList() — backed view, not a copy
 *  9.  remove(int index) vs remove(Object o) trap on List<Integer>
 * 10.  Fail-fast iterator — ConcurrentModificationException demo
 * 11.  Safe removal via Iterator.remove()
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        basicOperations();
        growthAndCapacity();
        middleVsEndPerformance();
        sorting();
        toArrayConversion();
        nullElements();
        subListView();
        removeOverloadTrap();
        failFastIterator();
        safeRemovalViaIterator();
    }

    // -------------------------------------------------------------------------
    // 1. Basic add / get / set / remove
    // -------------------------------------------------------------------------
    static void basicOperations() {
        System.out.println("=== 1. Basic Operations ===");

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("List      : " + list);
        System.out.println("get(1)    : " + list.get(1));       // O(1)

        list.set(1, "Blueberry");
        System.out.println("After set : " + list);

        list.remove("Apple");                                    // remove by value
        System.out.println("After remove(\"Apple\") : " + list);

        list.add(0, "Avocado");                                  // insert at index 0 — O(n)
        System.out.println("After add(0, \"Avocado\") : " + list);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 2. Internal growth — ensureCapacity() and trimToSize()
    // -------------------------------------------------------------------------
    static void growthAndCapacity() {
        System.out.println("=== 2. Growth and Capacity ===");

        // Default capacity is 10; no public API exposes it directly,
        // but we can observe behaviour by pre-sizing.
        ArrayList<Integer> list = new ArrayList<>();            // default capacity = 10

        // Pre-allocate for 1 000 elements — avoids repeated resizing
        list.ensureCapacity(1_000);
        for (int i = 0; i < 1_000; i++) list.add(i);
        System.out.println("Size after 1 000 adds : " + list.size());

        // Shrink backing array to exactly size()
        list.trimToSize();
        System.out.println("trimToSize() called — backing array shrunk to fit " + list.size() + " elements");
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 3. Middle insert/remove is O(n) because of array shifting
    // -------------------------------------------------------------------------
    static void middleVsEndPerformance() {
        System.out.println("=== 3. Middle vs End Performance ===");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Before : " + list);

        list.add(2, 99);   // shifts elements 2..end right — O(n)
        System.out.println("After add(2, 99) : " + list);

        list.remove(2);    // shifts elements 3..end left — O(n)
        System.out.println("After remove(2)  : " + list);

        list.add(999);     // appended at end — O(1) amortized
        System.out.println("After add(999) at end : " + list);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 4. Sorting
    // -------------------------------------------------------------------------
    static void sorting() {
        System.out.println("=== 4. Sorting ===");

        List<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry", "Date"));

        Collections.sort(list);
        System.out.println("Natural order  : " + list);

        list.sort(Comparator.reverseOrder());
        System.out.println("Reverse order  : " + list);

        list.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("By length then alpha : " + list);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 5. Converting ArrayList to array
    // -------------------------------------------------------------------------
    static void toArrayConversion() {
        System.out.println("=== 5. toArray() Conversion ===");

        ArrayList<String> list = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        String[] arr = list.toArray(new String[0]);   // recommended idiom

        System.out.println("Array contents : " + Arrays.toString(arr));
        System.out.println("Array length   : " + arr.length);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 6. Null elements — multiple nulls allowed
    // -------------------------------------------------------------------------
    static void nullElements() {
        System.out.println("=== 6. Null Elements ===");

        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add(null);
        list.add("B");
        list.add(null);

        System.out.println("List           : " + list);
        System.out.println("size()         : " + list.size());
        System.out.println("contains(null) : " + list.contains(null));
        System.out.println("indexOf(null)  : " + list.indexOf(null));
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 7. subList() returns a backed VIEW — not an independent copy
    // -------------------------------------------------------------------------
    static void subListView() {
        System.out.println("=== 7. subList() — backed view ===");

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        List<String> sub  = list.subList(1, 4);   // B, C, D

        System.out.println("Original : " + list);
        System.out.println("subList  : " + sub);

        sub.set(0, "X");   // modifies the original list too
        System.out.println("After sub.set(0, \"X\") — original : " + list);

        sub.clear();       // removes B..D from original
        System.out.println("After sub.clear()     — original : " + list);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 8. remove(int) vs remove(Object) trap on List<Integer>
    // -------------------------------------------------------------------------
    static void removeOverloadTrap() {
        System.out.println("=== 8. remove(int) vs remove(Object) trap ===");

        List<Integer> list1 = new ArrayList<>(Arrays.asList(10, 20, 30));
        list1.remove(1);                      // removes element at INDEX 1 → [10, 30]
        System.out.println("remove(1)               → by index   : " + list1);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(10, 20, 30));
        list2.remove(Integer.valueOf(20));    // removes element with VALUE 20 → [10, 30]
        System.out.println("remove(Integer.valueOf(20)) → by value : " + list2);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 9. Fail-fast iterator — structural modification during iteration
    // -------------------------------------------------------------------------
    static void failFastIterator() {
        System.out.println("=== 9. Fail-fast Iterator ===");

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        try {
            for (String s : list) {
                if (s.equals("B")) {
                    list.remove(s);   // structural modification during for-each
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught — as expected for fail-fast iterator");
        }
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 10. Safe removal via Iterator.remove()
    // -------------------------------------------------------------------------
    static void safeRemovalViaIterator() {
        System.out.println("=== 10. Safe Removal via Iterator.remove() ===");

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "B", "D"));
        System.out.println("Before : " + list);

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals("B")) {
                it.remove();   // safe — does not trigger ConcurrentModificationException
            }
        }

        System.out.println("After removing all \"B\" via Iterator : " + list);
        System.out.println();
    }
}

