package com.expedia.interview.java;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindLargestInArray {
    public static void main(String[] args) {
        int[] array = {2, 80, 55, 90, 1};


        int largest = 0;
        for (int i = 0; i < array.length; i++) {
            if (largest < array[i]) {
                largest = array[i];
            }
            System.out.println("largest: " + largest);
        }
        sortInt(array);
    }


    public static void sortInt(int[] arr) {
        Arrays.sort(arr);
        int lastIndex = arr.length - 1;
        System.out.println("largest: " + arr[lastIndex]);
    }

}
