package com.company;

public class Book {
     //书库
     private int BookNUm=1;
     private static Book OneBook=new Book();
     private Book(){ }
     public static Book getBook(){
         return OneBook;
     }

     public synchronized int getBookNUm(){
          return BookNUm;
     }

     public boolean addBookNum(){
          if(this.getBookNUm()<3) {this.BookNUm++;return true;}
          return false;
     }

     public boolean miusBookNum(){
          if(this.getBookNUm()>0){this.BookNUm--;return true;}
          return false;
     }
}
