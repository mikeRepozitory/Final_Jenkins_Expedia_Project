package com.expedia.interview.java;

import org.testng.annotations.Test;

public class RemoveWhiteSpace {
    public static void main(String[] args) {
        String name = " h el lo ";
        String noSpace = "";

        //   System.out.println(n.trim().charAt(1));

        //  char[] chars = name.toCharArray();


        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                noSpace = noSpace + name.charAt(i);
            }
        }
        System.out.println("noSpace result: " + noSpace);


        StringBuilder spaceFree = new StringBuilder();
        char[] chars = name.toCharArray();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                spaceFree.append(chars[i]);
            }
        }
        System.out.println("spaceFree result : " + spaceFree);
    }


}



