package com.expedia.interview.java;

public class OddNumbers {

    public static void main(String[] args) {
        int[] num = new int[]{2, 5, 1, 4, 6, 6, 8};

        for (int i = 0; i < num.length - 1; i++) {
            System.out.println("result: " + num[i] % 2);
        }
        containsOddNumbers(num);
    }

    public static boolean containsOddNumbers(int[] mums) {
        for (int j : mums) {
            if (j % 2 != 0) {
                System.out.println("no add numbers: " + j);
                return true;
            }
        }
        System.out.println("no add numbers: ");
        return false;
    }

}
