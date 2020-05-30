package com.company;

import java.util.Random;

public class ReturnThread implements Runnable {
    //还书线程，生产者
    @Override
    public void run() {
        Random random = new Random();

        //模拟还书的个数。
        int x = random.nextInt(10);

        System.out.println("一共产生了" + x + "个还书");

        while (x > 0) {
            Book book = Book.getBook();
            int bookNum = book.getBookNum();
            if ((bookNum = book.addBookNum()) != -1) {
                System.out.println("还书--剩余书量" + bookNum);
            } else {
                System.out.println("还书--已满");
                break;
            }
            x--;
        }
    }
}




