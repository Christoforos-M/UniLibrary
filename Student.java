package unilibrary;

import unilibrary.Book.Biblio;

public class Student {
    private String name;
    private Book booksBorrowedList[] = new Book[10];
    private int borbooks = 0;
    private static int max_Num_Books = 5;
    
    public Student(String name){
        this.name = name;
    }
    
    public void borrowBook(int isbn, Library lib, String name, String returned){
        if (borbooks < 5){
            lib.borrowBook(isbn, name, returned);
        } else {
            System.out.println("Ο μαθητης δεν μπορει να δανιστει αλλα βιβλια.");
        }
    }
    
    public static void setMaxNumBooks(int num){
        if ((num>=0) && (num <= 10))
            max_Num_Books = num;
        else
            max_Num_Books = 0;
    }
    
    //Δημιουργουμε μια αφηρημενη κλαση για το pattern της γεφυρας
    public static abstract class Mathitis {
    
        protected Biblio duration;
    
        public Mathitis(Biblio d) {
            this.duration = d;
        }
    
        abstract public int getLoanDuration();
    }
    
}