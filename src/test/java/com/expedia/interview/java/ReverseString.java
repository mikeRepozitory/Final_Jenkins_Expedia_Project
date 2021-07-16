package com.expedia.interview.java;

import org.testng.annotations.Test;

public class ReverseString {

    String name = "hello";
    StringBuffer string = new StringBuffer("hello");

    @Test
    public void printString() {
        System.out.println("lenght: " + name.length());
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
    }

    @Test
    public void reverse() {
        for (int i = name.length() - 1; i >= 0; i--) {
            System.out.println(name.charAt(i));
        }
    }

    @Test
    public void reverseString() {
        char[] a = name.toCharArray();

        for (int i = a.length; i >= 0; i--) {
        }
    }

    @Test
    public void reverseStringUsingStrinBUffer() {
        System.out.println("reverse; " + string.reverse());
    }


}



