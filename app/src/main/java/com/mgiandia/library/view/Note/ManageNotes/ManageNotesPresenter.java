package com.mgiandia.library.view.Note.ManageNotes;

import java.util.ArrayList;
import java.util.List;

import com.mgiandia.library.dao.ContactDAO;
import com.mgiandia.library.dao.NoteDAO;
import com.mgiandia.library.domain.Note;
import com.mgiandia.library.util.Quadruple;



public class ManageNotesPresenter
{
    private ManageNotesView view;

    private NoteDAO books;
    private ContactDAO authors;

    private Integer attachedAuthorID;

    /**
     * Επιστρέφει τα δεδομένα για μία λίστα από βιβλία books.
     * @param books Τα βιβλία στα οποία θα επιστραφούν τα δεδομένα
     * @return Μία λίστα με τις λεπτομέρειες των βιβλίων books
     */
    private List<Quadruple> createDataSource(List<Note> books)
    {
        List<Quadruple> triplets = new ArrayList<>();

        for(Note book : books)
            triplets.add(new Quadruple(book.getId(), "Από "+", "+book.getPublicationYear(), book.getTitle(), "Κωδικός: "+book.getId()+".  Συγγραφείς: "+book.getAuthors().size()));

        return triplets;
    }

    /**
     * Αρχικοποεί τον Presenter.
     * @param view Ένα instance του view
     * @param books Ένα instance του book
     * @param authors Ένα instance του author
     * @param publishers Ένα instance του publisher
     */
    public ManageNotesPresenter(ManageNotesView view, NoteDAO books, ContactDAO authors)
    {
        this.view = view;
        this.books = books;
        this.authors = authors;

        this.attachedAuthorID = view.getAttachedAuthorID();

        if(attachedAuthorID != null)
            view.setPageName("Βιβλία Συγγραφέα #" + attachedAuthorID);

        onLoadSource();
    }


    /**
     * Αποφασίζει από ποιο activity πραγματοποιήθηκε
     * το click.
     * @param uid To μοναδικό id
     */
    void onClickItem(int uid)
    {
        if(!view.shouldLoadItemsOnClick())
            view.clickItem(uid);
        else
            view.clickItemList(uid);
    }

    /**
     * Ξεκινάει το activity AddEditBookActivity
     */
    void onStartAddNew()
    {
        view.startAddNew();
    }


    /**
     * Εμφανίζει ένα Toast.
     * @param value Το περιεχόμενο που θα εμφανιστεί
     */
    void onShowToast(String value)
    {
        view.showToast(value);
    }

    /**
     * Φορτώνει την λίστα με τα βιβλία
     */
    void onLoadSource()
    {
        List<Note> toReturn;


        toReturn = books.findAll();

        view.loadSource(createDataSource(toReturn));
    }


}
