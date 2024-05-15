package com.mgiandia.library.dao;

import com.mgiandia.library.domain.Task;

import java.util.List;
import java.util.Set;



public interface TaskDAO
{
    /**
     * Διαγράφει ένα βιβλίο.
     * @param entity Το βιβλίο
     */
    void delete(Task entity);

    /**
     * Επιστρέφει όλα τα βιβλία.
     * @return Τα βιβλία
     */
    List<Task> findAll();

    /**
     * Αποθηκεύει ένα βιβλίο.
     * @param entity Το βιβλίο
     */
    void save(Task entity);

    /**
     * Βρίσκει ένα βιβλίο με βάση τον κωδικό του.
     * @param uid Ο κωδικός του βιβλίο
     * @return Το βιβλίο που βρέθηκε ή null
     */
    Task find(int uid);

    /**
     * Επιστρέφει τον επόμενο κωδικό που μπορεί να αποδοθεί σε ένα βιβλίο.
     * @return Ο κωδικός του βιβλίου
     */
    int nextId();

    Set<Task> findByTitle(String title);

    Set<Task> findByAuthorName(String authorName);
}
