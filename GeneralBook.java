package unilibrary;

import unilibrary.Book.Biblio;

//Η κλαση θετει στην μεθοδο getLoanDuration την διαρκεια δανισμου του βιβλιου GeneralBook
class GeneralBook implements Biblio{

    @Override
    public int getLoanDuration() {
        return 10;
    }

    
}