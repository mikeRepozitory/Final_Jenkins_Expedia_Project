package com.expedia.interview.java;

public class ReverseInt {


    public static void main(String[] args) {
        int number = 3543;

        int revers = 0;
        int remainder = 0;
        do {
            remainder = number % 10;
            revers = revers * 10 + remainder;
            number = number / 10;
        } while (number > 0);
        System.out.println(revers);
    }
}
