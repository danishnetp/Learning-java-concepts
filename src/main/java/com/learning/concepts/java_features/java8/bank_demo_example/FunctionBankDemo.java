package com.learning.concepts.java_features.java8.bank_demo_example;

import java.util.List;
import java.util.function.Function;

public class FunctionBankDemo {
    public static void main(String[] args) {
        List<Bank> customerList = List.of(
                new Bank("Ravi", 123456789L),
                new Bank("Pankaj", 987654321L),
                new Bank("Suresh", 456789123L)
        );

        Function<Bank, String> fun = Bank::getCustomerName;
        for(Bank bank : customerList){
            System.out.println("Customer Name: " + fun.apply(bank));
        }
    }
}
