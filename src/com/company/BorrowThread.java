package com.company;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Random;

public class BorrowThread implements Runnable {
    //借书线程，消费者。
    @Override
    public synchronized void run() {
        Random random=new Random();
        int x=random.nextInt(10);//模拟还书的个数
        while(x<5)random.nextInt(10);
        while(x>0) {
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) { }
            if (Book.getBook().miusBookNum()) {
                System.out.println("剩余书量" + Book.getBook().getBookNUm());
            } else {
                System.out.println("已空");
            }
            x--;
        }
    }
}
