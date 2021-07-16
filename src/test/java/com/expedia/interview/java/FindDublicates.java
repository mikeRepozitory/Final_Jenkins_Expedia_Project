package com.expedia.interview.java;

public class FindDublicates {
    public static void main(String[] args) {
        int[] array = {2, 80, 1, 55, 2, 90, 1};
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println(array[i]);
                }
            }
        }
    }
}
