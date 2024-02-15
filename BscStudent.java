package unilibrary;

import unilibrary.Book.Biblio;
import unilibrary.Student.Mathitis;

//Γινεται η προσθεση μεταξυ τις διαρκειας δανισμου του βιβλιου με την προσθετη διαρκεια που δινει το ειδος μαθητη BscStudent
public class BscStudent extends Mathitis{

    public BscStudent(Biblio d){
        super(d);
    }
    
    @Override
    public int getLoanDuration() {
        return 0 + duration.getLoanDuration();
    }
}