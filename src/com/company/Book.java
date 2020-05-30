package com.company;

/**
 * 单例模式
 */
public class Book {
    //书库
    private volatile int bookNUm = 1;
    private static final Book oneBook = new Book();

    /**
     * 标记是否可以还书
     */
    private boolean flag = false;

    private Book() {
    }

    public static Book getBook() {
        return oneBook;
    }

    /**
     * 获取当前的书本数量
     * @return
     */
    public synchronized int getBookNum() {
        return bookNUm;
    }


    /**
     * 添加书本数量
     * 还书
     * @return
     */
    public int addBookNum() {
        if (this.getBookNum() < 3) {
            if (flag) {
                super.notify();
            }
            //当借书线程无书可洁时，等待，当还书成功后，唤起。
            this.bookNUm++;
            return bookNUm;
        }
        return -1;
    }

    /**
     * 减少书本数量
     * 借书
     * @return
     */
    public int miusBookNum() {
        if (this.getBookNum() <= 0) {
            flag = false;
        } else {
            this.bookNUm--;
            return bookNUm;
        }
        return bookNUm;
    }
}
