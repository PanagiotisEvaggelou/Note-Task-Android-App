package com.mgiandia.library.dao;

import java.util.List;
import java.util.Set;

import com.mgiandia.library.domain.Note;



public interface NoteDAO
{
    /**
     * Διαγράφει ένα βιβλίο.
     * @param entity Το βιβλίο
     */
    void delete(Note entity);

    /**
     * Επιστρέφει όλα τα βιβλία.
     * @return Τα βιβλία
     */
    List<Note> findAll();

    /**
     * Αποθηκεύει ένα βιβλίο.
     * @param entity Το βιβλίο
     */
    void save(Note entity);

    /**
     * Βρίσκει ένα βιβλίο με βάση τον κωδικό του.
     * @param uid Ο κωδικός του βιβλίο
     * @return Το βιβλίο που βρέθηκε ή null
     */
    Note find(int uid);

    /**
     * Επιστρέφει τον επόμενο κωδικό που μπορεί να αποδοθεί σε ένα βιβλίο.
     * @return Ο κωδικός του βιβλίου
     */
    int nextId();

    Set<Note> findByTitle(String title);

    Set<Note> findByAuthorName(String authorName);
}
