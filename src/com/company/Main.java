package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
         //启动结束线程
	     new Thread(new BorrowThread()).start();
	     //启动还书线程
	     new Thread(new ReturnThread()).start();
    }
}
