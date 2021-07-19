package com.expedia.base;

public class CustomWait {


    public void waitFor(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
