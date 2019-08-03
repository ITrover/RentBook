package com.company;

public class Book {
     //书库
     private int BookNUm=1;
     private static Book OneBook=new Book();
     private boolean flag=false;
     private Book(){ }

     public static Book getBook(){
         return OneBook;
     }

     public synchronized int getBookNUm(){
          return BookNUm;
     }
     //无论借书还是还书都会先访问这个方法，从而实现线程安全。
     public boolean addBookNum(){
          if(this.getBookNUm()<3) {
               if(flag)super.notify();
               //当借书线程无书可洁时，等待，当还书成功后，唤起。
               this.BookNUm++; return true;
          }
          return false;
     }

     public boolean miusBookNum(){
          if(this.getBookNUm()<=0){
               //当无书可借时，等待还书后再借。
               try{
                    flag=true;
                    super.wait(300);
                    //最多等待3m
               } catch (InterruptedException e) { }
          }
          if(this.getBookNUm()>0){this.BookNUm--;return true;}
          return false;
     }
}
