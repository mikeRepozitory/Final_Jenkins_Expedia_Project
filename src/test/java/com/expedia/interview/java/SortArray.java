package com.expedia.interview.java;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, -1, -2, 3};
        System.out.println("before sort" + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("after sort" + Arrays.toString(numbers));

        char[] chars = {'a', 'g', 't', 's'};
        System.out.println("chars before sort" + Arrays.toString(chars));
        Arrays.sort(chars);
        System.out.println("chars after sort" + Arrays.toString(chars));

        String[] names = {"anna, Jack, Billy, Henry"};
        System.out.println("before sort: " + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("after sort: " + Arrays.toString(names));


        int[] numbers_1 = {1, 2, 3, -1, -2, 3};
        System.out.println("numbers_1 before sort: " + Arrays.toString(names));

        int temp = 0;
        for (int i = 0; i < numbers_1.length; i++) {

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] > numbers_1[j]) {
                    temp = numbers_1[i];
                    numbers_1[i] = numbers_1[j];
                    numbers_1[j] = temp;
                }

            }
        }
        System.out.println(" numbers_1 after sort: " + Arrays.toString(names));
        System.out.println(Arrays.toString(numbers_1));

    }
}
