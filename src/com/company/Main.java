package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	     new Thread(new BorrowThread()).start();
	     new Thread(new ReturnThread()).start();
    }
}
