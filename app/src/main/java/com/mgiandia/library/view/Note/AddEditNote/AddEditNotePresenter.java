package com.mgiandia.library.view.Note.AddEditNote;

import com.mgiandia.library.dao.ContactDAO;
import com.mgiandia.library.dao.NoteDAO;
import com.mgiandia.library.dao.ItemDAO;
import com.mgiandia.library.domain.Note;
import com.mgiandia.library.domain.ISBN;
import com.mgiandia.library.domain.Item;
import com.mgiandia.library.memorydao.NoteDAOMemory;



public class AddEditNotePresenter {

    private AddEditNoteView view;

    private NoteDAO books;
    private ContactDAO authors;
    private ItemDAO items;

    private Note attachedBook;

    /**
     * Επαληθεύει ότι ενα κείμενο περιέχει
     * μόνο αριθμούς.
     * @param in To text που θα επαληθευτεί
     * @return true αν περιέχει μόνο αριθμούς
     * αλλιώς false.
     */
    private boolean verifyOnlyDigits(String in)
    {
        for(int i = 0; i < in.length(); i++)
            if(!Character.isDigit(in.charAt(i)))
                return false;

        return true;
    }

    /**
     * Αρχικοποεί τον Presenter έτσι ώστε
     * αργότερα να προσθέσει ή να τροποποιήσει.
     * @param view Ένα instance του view
     * @param books Ένα instance του book
     * @param publishers Ένα instance του publisher
     * @param authors Ένα instance του author
     * @param items Ένα instance του Item
     */
    public AddEditNotePresenter(AddEditNoteView view, NoteDAOMemory books, ContactDAO authors, ItemDAO items)
    {
        this.view = view;
        this.books = books;
        this.authors = authors;
        this.items = items;


        Integer attachedBookID = view.getAttachedBookID();
        attachedBook = attachedBookID == null ? null : books.find(attachedBookID);

        if(attachedBook != null)//edit mode
        {

            view.setBookTitle(attachedBook.getTitle());
            view.setContent(attachedBook.getContent());
        }
    }

    /**
     * Αποθηκεύει το βιβλίο. Ελέγχει αν ο τίτλος, το ISBN και η δημοσίευση
     * ειναι από 2 εώς 15 χαρακτήρες. Επίσης ελέγχει αν έχει επιλεγθει
     * εκδοτικός οίκος και συγγραφέας. Τέλος ενημερώνει αν ήταν
     * επιτυχής η εισαγωγή ή η τροποποίηση του βιβλίου.
     */
    public void onSaveBook()
    {
            String
                title = view.getBookTitle(),
                content = view.getContent(),
                isbn = "yyy",
                publication = "yyy",
                year = "2002";

            if(attachedBook == null)//add
            {
                Note bookTmp = new Note(books.nextId(), title, content, new ISBN(isbn), publication, Integer.parseInt(year));
                books.save(bookTmp);

                Item itemTmp = new Item(items.nextId());
                itemTmp.setBook(bookTmp);

                items.save(itemTmp);

                view.successfullyFinishActivity("Επιτυχής Προσθήκη του Βιβλίου '"+title+"'!");
            }
            else//update
            {
                attachedBook.setTitle(title);
                attachedBook.setContent(content);
                attachedBook.setIsbn(new ISBN(isbn));
                attachedBook.setPublication(publication);
                attachedBook.setPublicationYear(Integer.parseInt(year));


                view.successfullyFinishActivity("Επιτυχής Τροποποίηση του Βιβλίου '"+title+"'!");
            }

    }

}
