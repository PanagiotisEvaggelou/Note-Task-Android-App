package com.mgiandia.library.view.Contact.ManageContacts;

import java.util.List;

import com.mgiandia.library.util.Quadruple;



public interface ManageContactsView
{
    /**
     * Μεταφερει τον χρήστη στο activity AuthorDetailsActivity
     * όταν γίνει click πάνω στον συγγραφέα με id uid.
     * @param uid Το μοναδικό id του συγγραφέα
     */
    void clickItem(int uid);

    /**
     * Ξεκινάει το activity AddEditAuthorActivity
     */
    void startAddNew();

    /**
     * Φορτώνει την λίστα με τους συγγραφείς
     * @param input Η λίστα που θα φορτώσει
     */
    void loadSource(List<Quadruple> input);

    /**
     * Εμφανίζει ένα Toast.
     * @param value Το περιεχόμενο που θα εμφανιστεί
     */
    void showToast(String value);
}
