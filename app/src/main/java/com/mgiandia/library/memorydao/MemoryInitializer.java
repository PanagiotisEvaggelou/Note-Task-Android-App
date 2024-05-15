package com.mgiandia.library.memorydao;

import com.mgiandia.library.dao.ContactDAO;
import com.mgiandia.library.dao.NoteDAO;
import com.mgiandia.library.dao.Initializer;
import com.mgiandia.library.dao.ItemDAO;
import com.mgiandia.library.dao.TaskDAO;
import com.mgiandia.library.domain.Contact;
import com.mgiandia.library.domain.Note;
import com.mgiandia.library.domain.Item;

public class MemoryInitializer extends Initializer {

    /**
     * Διαγράφει τα αποθηκευμένα δεδομένα.
     */
    @Override
    protected void eraseData() {

        for(Contact author : getAuthorDAO().findAll()) {
            getAuthorDAO().delete(author);
        }

        for(Note book : getBookDAO().findAll()) {
            getBookDAO().delete(book);
        }

        for(Item item : getItemDAO().findAll()) {
            getItemDAO().delete(item);
        }
    }

    /**
     * Επιστρέφει το DAO των συγγραφέων.
     * @return Το DAO των συγγραφέων
     */
    @Override
    public ContactDAO getAuthorDAO()
    {
        return new ContactDAOMemory();
    }

    /**
     * Επιστρέφει το DAO των βιβλίων.
     * @return Το DAO των βιβλίων
     */
    @Override
    public NoteDAO getBookDAO()
    {
        return new NoteDAOMemory();
    }


    /**
     * Επιστρέφει το DAO των αντιτύπων.
     * @return Το DAO των αντιτύπων
     */
    @Override
    public ItemDAO getItemDAO() {
        return new ItemDAOMemory();
    }

    @Override
    public TaskDAO getTaskDAO() {
        return new TaskDAOMemory();
    }



}