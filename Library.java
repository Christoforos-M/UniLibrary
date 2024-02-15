package unilibrary;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author dxa
 */
public class Library {

    // Ιδιότητες

    /**
     * Το όνομα της βιβλιοθήκης.
     */
    private String name;
    /**
     * Η λίστα των βιβλίων της βιβλιοθήκης.
     */
    
    ArrayList<Book> bookList = new ArrayList<>();

    /**
     * Ο αριθμός των βιβλίων στη λίστα.
     */
    private int num_books = 0;
    //public int loandays;
    // Μέθοδος για τον καθορισμό του ονόματος της βιβλιοθήκης

    /**
     * Ορίζει το όνομα της βιβλιοθήκης.
     *
     * @param name Το νέο όνομα της βιβλιοθήκης.
     */
    public void setName(String name) {
        this.name = name;
    }

    // Μέθοδος για την προσθήκη ενός βιβλίου στη λίστα

    /**
     * Προσθέτει ένα βιβλίο στη λίστα.
     *
     * @param abook Το βιβλίο που θα προστεθεί στη λίστα.
     */

    public void addBook(Book abook) {
        bookList.add(abook);
        num_books++;
    }

    // Μέθοδος για τον έλεγχο ύπαρξης ενός βιβλίου στη λίστα

    /**
     * Ελέγχει εάν υπάρχει ένα βιβλίο στη λίστα με συγκεκριμένο αριθμό ISBN.
     *
     * @param isbn Ο αριθμός ISBN του βιβλίου που θα ελεγχθεί.
     * @return Το βιβλίο εάν υπάρχει, διαφορετικά `null`.
     */
    public Book checkIfBookExists(int isbn) {
        for (int i = 0; i < num_books; i++) {
            if (bookList.get(i).getIsbn() == isbn) {
                return bookList.get(i);
            }
        }
        return null;
    }
    // Μέθοδος για το δανεισμό ενός βιβλίου από τη λίστα

    /**
     * Δανείζει ένα βιβλίο από τη λίστα.
     *
     * @param isbn Ο αριθμός ISBN του βιβλίου που θα δανειστεί.
     * @param borrower
     */
    public void borrowBook(int isbn, String borrower, String returned) {
        Book book = checkIfBookExists(isbn);

        if (book == null) {
            System.out.println("Το βιβλίο με ISBN " + isbn + " δεν υπάρχει");
            return;
        }
        if (book.isBorrowed()) {
            if(book.getReturnStatus() == "loaned"){
                System.out.println("Το βιβλίο με ISBN " + isbn + " δεν είναι διαθέσιμο");
                return;
            } else {
                System.out.println("Το βιβλίο εχει επιστραφει.);");
                return;
            }
        }
        book.setBorrowed(true, borrower, returned);
        System.out.println(borrower +" έχει δανειστεί το βιβλίο με ISBN " + isbn + "!!");
    }

    // Μέθοδος για την εμφάνιση των βιβλίων της βιβλιοθήκης

    /**
     * Εμφανίζει τα βιβλία της βιβλιοθήκης και το εαν ειναι διαθεσιμα ή οχι και αν οχι ποσες μερες θα διαρκεσει ο δανισμος.
     */
    
    public void showLibraryBooks() {
        System.out.println();
        System.out.println("Η Πανεπιστημιακή Βιβλιοθήκη περιέχει τα ακόλουθα βιβλία:");
        for (int i = 0; i < num_books; i++ ) {
            System.out.print(bookList.get(i));
            System.out.print(", Διαθέσιμο για δανεισμό: ");
            if (bookList.get(i).isBorrowed()) {
                if(bookList.get(i).isBorrowed()){
                    System.out.println("Όχι! Αναμενόμενη επιστροφη σε " + bookList.get(i).isLoandays()+ " μέρες"); 
                }          
            } else {
                System.out.println("Ναι!");
            }
        }
    }
    
    //H μεθοδος εκτυπωνει στον φακελο το μυνημα το οποιο παιρνει απο την μεθοδο getMessagesForPrint
    public void printLoans() {
        try (FileWriter writer = new FileWriter("register.txt")) {
            for (int i = 0; i < num_books; i++) {
                writer.write(bookList.get(i).getMessagesForPrint() + System.lineSeparator());
            }
            System.out.println("Οι δανεισμοί εκτυπώθηκαν επιτυχώς στο αρχείο results.txt");
        } catch (IOException e) {
            System.out.println("Σφάλμα κατά την εγγραφή των δανεισμών στο αρχείο.");
            e.printStackTrace();
        }
    }
}
