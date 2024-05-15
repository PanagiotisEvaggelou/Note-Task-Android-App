package com.mgiandia.library.view.Contact.ManageContacts;

import java.util.ArrayList;
import java.util.List;

import com.mgiandia.library.dao.ContactDAO;
import com.mgiandia.library.domain.Contact;
import com.mgiandia.library.util.Quadruple;



public class ManageContactsPresenter
{
    private ManageContactsView view;
    private ContactDAO authors;

    /**
     * Δημιουργεί την λίστα με τους συγγραφείς
     * @param authors Η λίστα με τους συγγραφείς
     * @return Επιστρέφει την λίστα
     */
    private List<Quadruple> createDataSource(List<Contact> authors)
    {
        List<Quadruple> triplets = new ArrayList<>();

        for(Contact author : authors)
            triplets.add(new Quadruple(author.getId(), author.getFirstName(), author.getLastName(), "Σύνολο βιβλίων "+author.getBooks().size()));

        return triplets;
    }

    /**
     * Αρχικοποιεί τον presenter και θέτει ως
     * ManageAuthorsView το view και AuthorDAO
     * το authors. Τέλος φορτώνει την λίστα με
     * τους συγγραφείς.
     * @param view Το ManageAuthorsView
     * @param authors Οι authors
     */
    public ManageContactsPresenter(ManageContactsView view, ContactDAO authors)
    {
        this.view = view;
        this.authors = authors;

        onLoadSource();
    }

    /**
     * Μεταφέρει τον χρήστη στο activity AuthorDetailsActivity
     * όταν γίνει click πάνω στον συγγραφέα με id uid.
     * @param uid Το μοναδικό id του συγγραφέα
     */
    void onClickItem(int uid)
    {
        view.clickItem(uid);
    }

    /**
     * Ξεκινάει το activity AddEditAuthorActivity
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
     * Φορτώνει την λίστα με τους συγγραφείς
     */
    void onLoadSource()
    {
        view.loadSource(createDataSource(authors.findAll()));
    }
}
