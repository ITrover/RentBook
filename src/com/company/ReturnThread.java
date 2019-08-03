package com.company;

import java.util.Random;
import java.util.function.BinaryOperator;

public class ReturnThread implements Runnable {
    //还书线程，生产者
    @Override
    public void run() {
        Random random = new Random();
        int x = random.nextInt(10);//模拟还书的个数。
        while(x<5)random.nextInt(10);
        while (x > 0) {
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) { }
            if (Book.getBook().addBookNum()) {
                System.out.println("剩余书量" + Book.getBook().getBookNUm());
            } else {
                System.out.println("已满"+Book.getBook().getBookNUm());
            }
            x--;
        }
    }
}




