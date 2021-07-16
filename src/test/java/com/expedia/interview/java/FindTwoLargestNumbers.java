package com.expedia.interview.java;

import java.util.Arrays;

public class FindTwoLargestNumbers {

    public static void main(String[] args) {
        int[] array = {2, 80, 55, 90, 1};
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < array.length; i++) {
            if (largest < array[i]) {
                largest = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == largest) continue;
            if (secondLargest < array[i])
                secondLargest = array[i];
        }
        System.out.println("largest: " + largest);
        System.out.println("secondLargest: " + secondLargest);

    }


}
