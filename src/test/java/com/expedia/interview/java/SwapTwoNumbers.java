package com.expedia.interview.java;

import org.testng.annotations.Test;

public class SwapTwoNumbers {

    @Test
    public void swapTwoNumbersUsing3rdVariable() {
        int a = 4;
        int b = 2;

        int tem = a;
        a = b;
        b = tem;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void swapTwoNumbersUsing() {
        int o = 10;
        int p = 30;

        p = o + p;
        o = p - o;
        p = p - o;
        System.out.println("o->" +o);
        System.out.println("p->" +p);

    }


}
