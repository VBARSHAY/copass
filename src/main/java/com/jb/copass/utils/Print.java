package com.jb.copass.utils;/*
 *Created by User in 7/24/2022
 */
public class Print {

    private static int count = 1;
    private static final int SIZE = 100;

    public static void printCaption(String text){
        int len = text.length();

        int spaces = (SIZE-len)/2;

        for (int i = 0; i < spaces; i++) {
            System.out.print("@");
        }
        System.out.print(text);
        for (int i = 0; i < spaces; i++) {
            System.out.print("@");
        }
        System.out.println();
    }
}