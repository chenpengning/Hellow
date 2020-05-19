package com.example.mylibrary;

import java.util.ArrayList;
import java.util.HashMap;

public class MainTest {

    private static final int FLAG_ADD_STATES_FROM_CHILDREN = 0x70000;

    protected static final int FLAG_DISALLOW_INTERCEPT = 0x80000;

    private ArrayList list = new ArrayList<String>();


    public static void main(String[] args) {


        System.out.println((12 & 7));//1100 0000
        System.out.println((12 % 7));//1100 0000


        for (int i=0;i<5 ;i++){

            System.out.println("===i="+i);

            System.out.println("===xxxxx="+i);

            System.out.println("===0000="+i);

        }

        setnext();

    }


    private static void setnext(){

        System.out.println("======3");

        System.out.println("======3");

    }











}
