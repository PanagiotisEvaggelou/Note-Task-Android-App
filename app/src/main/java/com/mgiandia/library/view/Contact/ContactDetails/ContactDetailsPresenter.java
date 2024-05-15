package com.mgiandia.library.view.Contact.ContactDetails;

import com.mgiandia.library.dao.ContactDAO;
import com.mgiandia.library.domain.Contact;



public class ContactDetailsPresenter
{
    private ContactDetailsView view;
    private Contact attachedAuthor;

    /**
     * Αρχικοποεί τον Presenter.
     * @param view Ένα instance του view
     * @param authors Ένα instance του author
     */
    public ContactDetailsPresenter(ContactDetailsView view, ContactDAO authors)
    {
        this.view = view;

        attachedAuthor = authors.find(view.getAttachedAuthorID());

        view.setPageName("Συγγραφέας #" + attachedAuthor.getId());

        view.setFirstName(attachedAuthor.getFirstName());
        view.setLastName(attachedAuthor.getLastName());
    }

    /**
     * Εμφανίζει το κουμπί της επεξεργασίας του
     * συγγραφέα.
     */
    void onStartEditButtonClick()
    {
        view.startEdit(attachedAuthor.getId());
    }

    /**
     * Εμφανίζει ένα μήνυμα με περιεχόμενο value.
     * @param value Το περιεχόμενο του μηνύματος
     */
    void onShowToast(String value)
    {
        view.showToast(value);
    }
}
