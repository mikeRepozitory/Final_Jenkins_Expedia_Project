package com.expedia.interview.java;

public class SumOfDigits {
    public static void main(String[] args) {
        int a = 3241;
        int sum = 0;

        while (a > 0) {
            sum = sum + a % 10;
            a = a / 10;

        }
        System.out.println(sum
        );
    }
}
