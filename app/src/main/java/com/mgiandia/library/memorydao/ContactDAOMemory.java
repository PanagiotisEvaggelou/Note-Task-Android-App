package com.mgiandia.library.memorydao;

import java.util.ArrayList;
import java.util.List;

import com.mgiandia.library.dao.ContactDAO;
import com.mgiandia.library.domain.Contact;



public class ContactDAOMemory implements ContactDAO {
    protected static ArrayList<Contact> entities = new ArrayList<Contact>();

    /**
     * Διαγράφει έναν συγγραφέα.
     * @param entity Ο συγγραφέας
     */
    public void delete(Contact entity) {
        entities.remove(entity);
    }

    /**
     * Επιστρέφει όλους τους συγγραφείς.
     * @return Οι συγγραφείς
     */
    public List<Contact> findAll() {
        ArrayList<Contact> result = new ArrayList<Contact>();
        result.addAll(entities);
        return result;
    }

    /**
     * Αποθηκεύει έναν συγγραφέα.
     * @param entity Ο συγγραφέας
     */
    public void save(Contact entity) {
        entities.add(entity);
    }

    /**
     * Βρίσκει έναν συγγραφέα με βάση τον κωδικό του.
     * @param authorΙd Ο κωδικός του συγγραφέα
     * @return Ο συγγραφέας που βρέθηκε ή null
     */
    public Contact find(int authorΙd)
    {
        for(Contact author : entities)
            if(author.getId() == authorΙd)
                return author;

        return null;
    }

    /**
     * Επιστρέφει τον επόμενο κωδικό που μπορεί να αποδοθεί σε έναν συγγραφέα.
     * @return Ο κωδικός του συγγραφέα
     */
    @Override
    public int nextId()
    {
        return (entities.size() > 0 ? entities.get(entities.size()-1).getId()+1 : 1);
    }
}
