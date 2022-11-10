package com.example.shopping.utils;


public class StateHolder {
    private static String customerName = "temp";

    public static String getCustomerName() {
        return customerName;
    }

    public static void setCustomerName(String customerName) {
        StateHolder.customerName = customerName;
    }
}
