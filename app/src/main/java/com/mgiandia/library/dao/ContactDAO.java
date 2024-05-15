package com.mgiandia.library.dao;

import java.util.List;

import com.mgiandia.library.domain.Contact;



public interface ContactDAO
{
    /**
     * Διαγράφει έναν συγγραφέα.
     * @param entity Ο συγγραφέας
     */
    void delete(Contact entity);

    /**
     * Επιστρέφει όλους τους συγγραφείς.
     * @return Οι συγγραφείς
     */
    List<Contact> findAll();

    /**
     * Αποθηκεύει έναν συγγραφέα.
     * @param entity Ο συγγραφέας
     */
    void save(Contact entity);

    /**
     * Βρίσκει έναν συγγραφέα με βάση τον κωδικό του.
     * @param authorId Ο κωδικός του συγγραφέα
     * @return Ο συγγραφέας που βρέθηκε ή null
     */
    Contact find(int authorId);

    /**
     * Επιστρέφει τον επόμενο κωδικό που μπορεί να αποδοθεί σε έναν συγγραφέα.
     * @return Ο κωδικός του συγγραφέα
     */
    int nextId();
}
