package unilibrary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import unilibrary.Student.Mathitis;
public class UniLibraryMain {


    public static void main(String[] args) throws IOException {
       System.out.println("Απλή Εφαρμογή Πανεπιστημιακής Βιβλιοθήκης");
       System.out.println("=========================================");

       // Δημιουργήστε μια βιβλιοθήκη με όνομα «Πανεπιστημιακή Βιβλιοθήκη»
       Library unilib = new Library();
       unilib.setName("Πανεπιστημιακή Βιβλιοθήκη");
       
       File myObj = new File("register.txt");
       try {
        if (myObj.createNewFile()) {
            System.out.println("O φάκελος"+  myObj.getName()+ "δημιουργηθηκε.");
        } else {
            System.out.println("Ο φάκελος υπάρχει είδη.");
            }
       } catch (IOException e) {
            System.out.println("Προέκυψε ένα λάθος.");
            e.printStackTrace();
        }

       ArrayList<Integer> days = new ArrayList<>();
       // Δημιουργήστε τρία (3) βιβλία με τα εξής στοιχεία: 
       // 1 βιβλίο με ISBN 86 και τίτλο «Ambient Intelligence»
       // 1 βιβλίο με ISBN 18 και τίτλο «Software Engineering»
       // 1 βιβλίο με ISBN 51 και τίτλο «Αλγόριθμοι Μηχανικής Μάθησης»
       
       Mathitis stu1 = new BscStudent(new GeneralBook());
       Book book1 = new Book(86, "Ambient Intelligence","GB",stu1.getLoanDuration(), "loaned");
       
       
       Book book2 = new Book(18, "Software Engineering","BSc", 0, "loaned");
       
       
       Mathitis stu3 = new MscStudent(new GeneralBook());
       Book book3 = new Book(51, "Αλγόριθμοι Μηχανικής Μάθησης","BSc", stu3.getLoanDuration(), "loeaned");
       
       
       
       // Προσθέστε τα πιο πάνω βιβλία στη βιβλιοθήκη
       unilib.addBook(book1);
       unilib.addBook(book2);
       unilib.addBook(book3);
       
       // Δημιουργήστε δύο (2) φοιτητές με τα εξής στοιχεία: 
       // 1 φοιτητής με όνομα «Αχιλλέας Καμέας»
       // 1 φοιτητής με όνομα «Γιάννης Σταμέλος»
       Student std1 = new Student("Αχιλλέας Καμέας");
       Student std2 = new Student("Γιάννης Σταμέλος");
       
       // Ο φοιτητής με όνομα «Αχιλλέας Καμέας» προσπαθεί να δανειστεί
       // το βιβλίο με ISBN 86
       std1.borrowBook(86, unilib, "Αχιλλέας Καμέας", "returned");
       // Ο φοιτητής με όνομα «Αχιλλέας Καμέας» προσπαθεί να δανειστεί
       // το βιβλίο με ISBN 100
       std1.borrowBook(100, unilib, "", "");
       // Ο φοιτητής με όνομα «Γιάννης Σταμέλος» προσπαθεί να δανειστεί
       // το βιβλίο με ISBN 51
       std2.borrowBook(51, unilib, "Γιάννης Σταμέλος", "loaned");
       
        
       

       // Εμφανίστε όλα τα διαθέσιμα στοιχεία για τα βιβλία που 
       // διαθέτει η βιβλιοθήκη
       unilib.showLibraryBooks();
       unilib.printLoans();
    }

}
