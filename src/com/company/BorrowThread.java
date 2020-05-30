package com.company;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Random;

/**
 * 借书线程，消费者。
 */
public class BorrowThread implements Runnable {
    @Override
    public void run() {
        Random random = new Random();

        //模拟借书的个数
        int x = random.nextInt(10);
        System.out.println("一共产生了" + x + "个借书");

        while (x > 0) {
            Book book = Book.getBook();
            int bookNum = 0;
            if ((bookNum = book.miusBookNum()) != -1) {
                System.out.println("借书--剩余书量" + bookNum);
            } else {
                System.out.println("借书--已空");
            }
            x--;
        }
    }
}
