package com.learning.concepts.java_features.java8.bank_demo_example;

public class Bank {
    private final String customerName;
    private final long accountId;

    public Bank(String name, long accountId) {
        this.customerName = name;
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public long getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "customerName='" + customerName + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
