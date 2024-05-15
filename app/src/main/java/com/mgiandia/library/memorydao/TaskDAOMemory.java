
package com.mgiandia.library.memorydao;

        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;

        import com.mgiandia.library.dao.TaskDAO;
        import com.mgiandia.library.domain.Contact;
        import com.mgiandia.library.domain.Task;



public class TaskDAOMemory implements TaskDAO {
    protected static ArrayList<Task> entities = new ArrayList<Task>();

    /**
     * Διαγράφει ένα βιβλίο.
     * @param entity Το βιβλίο
     */
    public void delete(Task entity) {
        entities.remove(entity);
    }

    /**
     * Επιστρέφει όλα τα βιβλία.
     * @return Τα βιβλία
     */
    public List<Task> findAll() {
        ArrayList<Task> result = new ArrayList<Task>();
        result.addAll(entities);
        return result;
    }

    /**
     * Αποθηκεύει ένα βιβλίο.
     * @param entity Το βιβλίο
     */
    public void save(Task entity) {
        entities.add(entity);
    }

    /**
     * Βρίσκει ένα βιβλίο με βάση τον κωδικό του.
     * @param uid Ο κωδικός του βιβλίο
     * @return Το βιβλίο που βρέθηκε ή null
     */
    public Task find(int uid)
    {
        for(Task now : entities)
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
    public Set<Task> findByTitle(String title) {
        Set<Task> result = new HashSet<>();
        for(Task b: entities){
            if (b.getTitle().contains(title)){
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public Set<Task> findByAuthorName(String authorName) {
        Set<Task> result = new HashSet<>();
        for(Task b: entities){
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