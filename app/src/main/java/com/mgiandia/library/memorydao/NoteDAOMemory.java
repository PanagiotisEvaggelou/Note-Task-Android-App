package com.mgiandia.library.memorydao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mgiandia.library.dao.NoteDAO;
import com.mgiandia.library.domain.Contact;
import com.mgiandia.library.domain.Note;



public class NoteDAOMemory implements NoteDAO {
    protected static ArrayList<Note> entities = new ArrayList<Note>();

    /**
     * Διαγράφει ένα βιβλίο.
     * @param entity Το βιβλίο
     */
    public void delete(Note entity) {
        entities.remove(entity);
    }

    /**
     * Επιστρέφει όλα τα βιβλία.
     * @return Τα βιβλία
     */
    public List<Note> findAll() {
        ArrayList<Note> result = new ArrayList<Note>();
        result.addAll(entities);
        return result;
    }

    /**
     * Αποθηκεύει ένα βιβλίο.
     * @param entity Το βιβλίο
     */
    public void save(Note entity) {
        entities.add(entity);
    }

    /**
     * Βρίσκει ένα βιβλίο με βάση τον κωδικό του.
     * @param uid Ο κωδικός του βιβλίο
     * @return Το βιβλίο που βρέθηκε ή null
     */
    public Note find(int uid)
    {
        for(Note now : entities)
            if(now.getId() == uid)
                return now;

        return null;
    }

    /**
     * Επιστρέφει τον επόμενο κωδικό που μπορεί να αποδοθεί σε ένα βιβλίο.
     * @return Ο κωδικός του βιβλίου
     */
    @Override
    public int nextId()
    {
        return (entities.size() > 0 ? entities.get(entities.size()-1).getId()+1 : 1);
    }

    @Override
    public Set<Note> findByTitle(String title) {
        Set<Note> result = new HashSet<>();
        for(Note b: entities){
            if (b.getTitle().contains(title)){
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public Set<Note> findByAuthorName(String authorName) {
        Set<Note> result = new HashSet<>();
        for(Note b: entities){
            for(Contact a: b.getAuthors()){
                if (a.getLastName().contains(authorName)){
                    result.add(b);
                    break;
                }
            }
        }
        return result;
    }
}
