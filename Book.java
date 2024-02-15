package unilibrary;

public class Book {
    
    // The book's ISBN number.
    private int isbn;
    
    private int loandays;
    
    // The book's title.
    private String title;

    // Whether the book is currently borrowed.
    private boolean borrowed;
    private String borrower;
    private String booktype;
    private String returned;
    
    /**
     * Creates a new book with default values for ISBN and title.
     */
    public Book() {
        this.isbn = 0;
        this.title = "";
        this.borrowed = false;
        this.booktype = "";
        this.loandays = 0;
        this.returned = "";
    }

    /**
     * Creates a new book with the specified ISBN and title.
     *
     * @param isbn The book's ISBN number.
     * @param title The book's title.
     */
    public Book(int isbn, String title, String booktype, int loandays, String returned) {
        this.isbn = isbn;
        this.title = title;
        this.booktype = booktype;
        this.loandays = loandays;
        this.returned = returned;
    }

    /**
     * Gets the book's ISBN number.
     *
     * @return The book's ISBN number.
     */
    public int getIsbn() {
        return isbn;
    }
    
    /**
     * Sets the book's ISBN number.
     *
     * @param isbn The new ISBN number for the book.
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    public void setBookType() {
        this.booktype = booktype;
    }
    
    public String getBookType(){
        return booktype;
    }
    
    public void setReturnedStatus(){
        this.returned = returned;
    }
    
    public String getReturnStatus(){
        return returned;
    }
    
    /**
     * Checks whether the book is currently borrowed.
     *
     * @return True if the book is borrowed, false otherwise.
     */
    public boolean isBorrowed() {
        return borrowed;
    }
    
    public int isLoandays() {
        return loandays;
    }
    
    public void getLondays(){
        this.loandays = loandays;
    }
    
    /**
     * Sets the book's borrow status.
     *
     * @param borrowed True to mark the book as borrowed, false to mark it as available.
     * @param borrower
     */
    public void setBorrowed(boolean borrowed, String borrower, String returned) {
        this.borrowed = borrowed;
        this.borrower = borrower;
        this.returned = returned;
    }

    /**
     * Generates a string representation of the book.
     *
     * @return A string representation of the book, including its ISBN number and title.
     */
    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Τίτλος: " + title;
    }
    //Καθοριζουμε το interface Βιβλιο
    interface Biblio {
        
        public int getLoanDuration();
        
    }
    // Η μέθοδος δινει το μυνημα το οποιο θα εκτυπωθει στον φακελο
    public String getMessagesForPrint() {
        if (isBorrowed()) {
            if(returned == "loaned"){
                return title + ", " + borrower + ", " + booktype + ", on loan (διάρκεια:" + loandays + " μέρες)";
            }
            if(returned == "returned"){
                return title + ", " + borrower + ", " + booktype + "," + returned+ "";
            }
        } else {
            return title + ", δεν έχει δανειστεί ποτέ!";
        }
        return null;
    }
}
