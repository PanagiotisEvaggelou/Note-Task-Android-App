package com.mgiandia.library.domain;

import com.mgiandia.library.util.LibraryException;

/**
 * Το αντίτυπο ενός βιβλίου.
 * 
 *
 */
public class Item {

    private int itemNumber = 0;
    private Note book;
    private Task task;
    private ItemState state = ItemState.NEW;

    /**
     * Προκαθορισμένος κατασκευαστής.
     */
    public Item() { }


    /**
     * Βοηθητικός κατασκευαστής που δέχεται τον αριθμό εισαγωγής ως παράμετρο.
     * @param itemNumber Ο αριθμός εισαγωγής
     */
    public Item(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    /**
     * Θέτει τον αριθμό εισαγωγής του αντιτύπου.
     * Ο αριθμός εισαγωγής προσδιορίζει μοναδικά κάθε αντίτυπο.
     * @param itemNumber Ο αριθμός εισαγωγής.
     */
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    /**
     * Επιστρέφει τον αριθμό εισαγωγής του αντιτύπου.
     * Ο αριθμός εισαγωγής προσδιορίζει μοναδικά κάθε αντίτυπο.
     * @return Ο αριθμός εισαγωγής
     */
    public int getItemNumber() {
        return itemNumber;
    }


    /**
     * Θέτει το βιβλίο του αντιτύπου.
     * @param book  Το βιβλίο του αντιτύπου
     * @see Note#addItem(Item)
     */
    public void setBook(Note book) {
        if (this.book != null) {
            this.book.friendItems().remove(this);
        }
        this.book = book;
        if (this.book != null) {
            this.book.friendItems().add(this);
        }
    }

    /**
     * Θέτει το βιβλίο του αντιτύπου.
     * @param task  Το βιβλίο του αντιτύπου
     * @see Note#addItem(Item)
     */
    public void setTask(Task task) {
        if (this.task != null) {
            this.task.friendItems().remove(this);
        }
        this.task = task;
        if (this.task != null) {
            this.task.friendItems().add(this);
        }
    }

    /**
     * Επιστρέφει το βιβλίο του αντιτύπου.
     * @return Το βιβλίο του αντιτύπου
     */
    public Note getBook() {
        return book;
    }

    /**
     * Επιστρέφει το βιβλίο του αντιτύπου.
     *
     * @return Το βιβλίο του αντιτύπου
     */
    public Task getTask() {
        return task;
    }


    /**
     * Επιστρέφει την κατάσταση του αντιτύπου.
     * @return Η κατάσταση του αντιτύπου
     */
    public ItemState getState() {
        return state;
    }


    /**
     * θέτει την κατάσταση του αντιτύπου.
     * Προσοχή στην ορατότητα.
     * Δεν είναι δημόσια και δεν μπορεί οποιαδήποτε
     * κλάση να αλλάξει την κατάσταση
     * του αντιτύπου.
     * @param state Η κατάσταση του αντιτύπου.
     */
    protected void setState(ItemState state) {
        this.state = state;
    }


    /**
     * Αλλάζει την κατάσταση του αντιτύπου σε διαθέσιμο ({@code AVAILABLE}).
     */
    public void available() {
        if (getState().equals(ItemState.LOST)) {
            throw new LibraryException();
        }
        if (getState().equals(ItemState.WITHDRAWN)) {
            throw new LibraryException();
        }

        setState(ItemState.AVAILABLE);
    }

    /**
     * Το αντίτυπο αποσύρεται και δεν είναι διαθέσιμο για δανεισμό.
     */
    public void withdraw() {
    	if (! getState().equals(ItemState.AVAILABLE)) {
    		throw new LibraryException();
    	}
        setState(ItemState.WITHDRAWN);
    }

    /**
     * Το αντίτυπο έχει χαθεί και δεν είναι διαθέσιμο για δανεισμό.
     */
    public void lost() {
    	if (! getState().equals(ItemState.LOANED)) {
    		throw new LibraryException();
    	}
    	
        setState(ItemState.LOST);
    }

    /**
     * Το αντίτυπο με την μορφή string.
     * @return Το αντίτυπο
     */
    @Override
    public String toString() {
        return String.valueOf(itemNumber);
    }

}
