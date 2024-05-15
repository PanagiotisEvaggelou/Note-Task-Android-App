
package com.mgiandia.library.domain;

        import java.util.HashSet;
        import java.util.Set;

/**
 * Το βιβλίο.
 * 
 */
public class Task {
    private int uid;
    private ISBN isbn;
    private String title;
    private String content;
    private String publication;
    private int publicationyear;

    private Set<Item> items = new HashSet<Item>();
    private Set<Contact> authors = new HashSet<Contact>();

    /**
     * Προκαθορισμένος κατασκευαστής.
     */
    public Task() { }

    /**
     * Βοηθητικός κατασκευαστής που αρχικοποιεί τα βασικά στοιχεία ενός βιβλίου.
     * @param uid Ο μοναδικός κωδικός
     * @param title Τίτλος
     * @param isbn ISBN
     * @param publication Αριθμός έκδοσης
     * @param publicationYear Έτος έκδοσης
     */
    public Task(int uid, String title, String content, ISBN isbn, String publication,
                int publicationYear) {
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.isbn = isbn;
        this.publication = publication;
    }

    /**
     * Επιστρέφει τον μοναδικό κωδικό του βιβλίου.
     * @return Ο μοναδικός κωδικός του βιβλίου
     */
    public int getId() {
        return uid;
    }

    /**
     * Θέτει τον τίτλο του βιβλίου.
     * @param title Ο τίτλος του βιβλίου
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Επιστρέφει τον τίτλο του βιβλίου.
     * @return Ο Τίτλος του βιβλίου
     */
    public String getTitle() {
        return title;
    }

    /**
     * Επιστρέφει τo content του βιβλίου.
     * @return Ο Τίτλος του βιβλίου
     */
    public String getContent() {
        return content;
    }

    /**
     * Θέτει το περιεχόμενο του βιβλίου.
     * @param content Ο τίτλος του βιβλίου
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Θέτει το ISBN του βιβλίου.
     * @param isbn Το ISBN
     */

    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }

    /**
     * Επιστρέφει το ISBN του βιβλίου.
     * @return Το ISBN
     */
    public ISBN getIsbn() {
        return isbn;
    }

    /**
     * Θέτει τον αριθμό της έκδοσης του βιβλίου.
     * @param publication Ο αριθμός της έκδοσης
     */

    public void setPublication(String publication) {
        this.publication = publication;
    }


    /**
     * Επιστρέφει τον αριθμό της έκδοσης του βιβλίου.
     * @return Ο αριθμός της έκδοσης
     */
    public String getPublication() {
        return publication;
    }

    /**
     * Θέτει το έτος έκδοσης του βιβλίου.
     * @param publicationyear Το έτος έκδοσης
     */
    public void setPublicationYear(int publicationyear) {
        this.publicationyear = publicationyear;
    }

    /**
     * Επιστρέφει το έτος έκδοσης του βιβλίου.
     * @return Το έτος έκδοσης
     */
    public int getPublicationYear() {
        return publicationyear;
    }


    /**
     * Επιστρέφει τα αντίτυπα ({@link Item}) για κάποιο βιβλίο.
     * Η συλλογή των αντιτύπων είναι αντίγραφο.
     * Για την προσθήκη κάποιου αντιτύπου
     * στη συλλογή χρησιμοποιείστε τη μέθοδο {@link Note#addItem(Item)}
     * και για την απομάκρυνση ενός αντιτύπου
     * τη μέθοδο {@link Note#removeItem(Item)}.
     * @return Αντίγραφο της συλλογής των αντιτύπων του βιβλίου
     */
    public Set<Item> getItems() {
        return new HashSet<Item>(items);
    }


    /**
     * Επιστρέφει τους συγγραφείς ({@link Contact}) για κάποιο βιβλίο.
     * Η συλλογή των αντιτύπων είναι αντίγραφο. Για την
     * προσθήκη κάποιου συγγραφέα στη συλλογή χρησιμοποιείστε
     * τη μέθοδο {@link Note#addAuthor(Contact)} και για την
     * απομάκρυνση ενός αντιτύπου τη μέθοδο {@link Note#removeAuthor(Contact)}.
     * @return Αντίγραφο της συλλογής των συγγραφέων του βιβλίου
     */
    public Set<Contact> getAuthors() {
        return new HashSet<Contact>(authors);
    }

    /**
     * Προσθήκη ενός αντιτύπου ({@link Item}) στη συλλογή αντιτύπων του βιβλίου.
     * @param item Το αντίτυπο
     */
    public void addItem(Item item) {
        if (item != null) {
            item.setTask(this);
        }
    }

    /**
     * Απομάκρυνση ενός αντιτύπου ({@link Item}) από
     * τη συλλογή αντιτύπων του βιβλίου.
     * @param item Το αντίτυπο
     */
    public void removeItem(Item item) {
        if (item != null) {
            item.setTask(null);
        }
    }

    /**
     * Μη ενθυλακωμένη συλλογή των αντιτύπων του βιβλίου.
     * @return Τα αντίτυπα του βιβλίου
     */
    Set<Item> friendItems() {
        return items;
    }



    /**
     * Μη ενθυλακωμένη συλλογή των συγγραφέων του βιβλίου.
     * @return Οι συγγραφείς του βιβλίου
     */
    Set<Contact> friendAuthors() {
        return authors;
    }


    private boolean hasAvailableItems() {
        boolean itemsAvailable = false;

        for(Item i: items){
            if (i.getState().equals(ItemState.AVAILABLE)){
                itemsAvailable = true;
                break;
            }
        }
        return itemsAvailable;
    }
}
