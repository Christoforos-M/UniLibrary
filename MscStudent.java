package unilibrary;

import unilibrary.Book.Biblio;
import unilibrary.Student.Mathitis;
//Γινεται η προσθεση μεταξυ τις διαρκειας δανισμου του βιβλιου με την προσθετη διαρκεια που δινει το ειδος μαθητη MscStudent
public class MscStudent extends Mathitis {
    
    public MscStudent(Biblio d) {
        super(d);
    }
    
    @Override
    public int getLoanDuration() {
        return 2 + duration.getLoanDuration();
    } 
}