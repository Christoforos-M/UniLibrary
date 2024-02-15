package unilibrary;

import unilibrary.Book.Biblio;

//Η κλαση θετει στην μεθοδο getLoanDuration την διαρκεια δανισμου του βιβλιου BscBook
class BscBook implements Biblio{
    
    @Override
    public int getLoanDuration() {
        return 5;
    }
}