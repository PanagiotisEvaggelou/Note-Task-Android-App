package com.mgiandia.library.view.Contact.ContactDetails;



public interface ContactDetailsView
{
    int getAttachedAuthorID();

    /**
     * Θέτει το πρώτο όνομα του συγγραφέα.
     * @param value Το πρώτο όνομα του συγγραφέα
     */
    void setFirstName(String value);

    /**
     * Θέτει το επώνυμο του συγγραφέα.
     * @param value Το επώνυμο του συγγραφέα
     */
    void setLastName(String value);


    /**
     * Θέτει το όνομα της σελίδας.
     * @param value το όνομα της σελίδας
     */
    void setPageName(String value);

    /**
     * Ξεκινάει να τροποποιεί τον συγγραφέα με
     * id authorID.
     * @param authorID Το id του συγγραφέα
     */
    void startEdit(int authorID);

    /**
     * Εμφανίζει τα βιβλία του συγγραφέα με
     * id authorID.
     * @param authorID Το id του συγγραφέα
     */
    void startShowBooks(int authorID);

    /**
     * Εμφανίζει ένα Toast.
     * @param value Το περιεχόμενο που θα εμφανιστεί
     */
    void showToast(String value);
}
