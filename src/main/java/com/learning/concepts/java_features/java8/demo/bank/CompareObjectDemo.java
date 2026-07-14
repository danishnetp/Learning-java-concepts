package com.learning.concepts.java_features.java8.demo.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates object sorting in Java 8 using {@link Comparator} with method references.
 * <p>
 * This class shows how to:
 * <ul>
 *   <li>Sort by string field ({@code customerName}) in ascending order</li>
 *   <li>Sort by numeric field ({@code accountId}) in ascending order</li>
 *   <li>Reverse a comparator for descending order sorting</li>
 * </ul>
 */
public class CompareObjectDemo {

    /**
     * Runs the sorting examples on a small in-memory list of {@link Bank} objects.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Bank bank1 = new Bank("Ravi", 1001);
        Bank bank2 = new Bank("Pankaj", 1002);
        Bank bank3 = new Bank("Ravi", 1003);

        List<Bank> customerList = new ArrayList<>(List.of(bank1, bank2, bank3));

        // Sort by customer name in ascending lexical order.
        customerList.sort(Comparator.comparing(Bank::getCustomerName));
        System.out.println("Sort in ascending order by customer name: " + customerList);

        // Sort by account id in ascending order.
        Collections.sort(customerList, Comparator.comparing(Bank::getAccountId));
        System.out.println("Sort in ascending order by account id: " + customerList);

        // Reverse the account-id comparator for descending order.
        System.out.println("Sort in descending order.");
        Collections.sort(customerList, Comparator.comparing(Bank::getAccountId).reversed());
        System.out.println("Sort in descending order by account id: " + customerList);


    }
}
