package com.mgiandia.library.dao;

import com.mgiandia.library.domain.*;


public abstract class Initializer
{
    public static final int GIAKOUMAKIS_ID = 2;
    public static final int DIAMANTIDIS_ID = 8;

    public static final int UML_USER_GUIDE_ID1 = 3;
    public static final int UML_DISTILLED_ID1 = 1;
    public static final int UML_REFACTORING_ID = 5;
    public static final int UML_USER_GUIDE_ID2 = 4;
    public static final int UML_DISTILLED_ID2 = 2;

    /**
     * Διαγράφει τα αποθηκευμένα δεδομένα.
     */
    protected abstract void eraseData();

    /**
     * Προσθέτει ένα αντίτυπο ενός συγκεκριμένου βιβλίου.
     * @param book Το βιβλίο
     * @return Το αντίτυπο που προστέθηκε
     */
    private Item addOneBookItem(Note book)
    {
        ItemDAO item = getItemDAO();
        Item itemTmp = new Item(item.nextId());
        itemTmp.setBook(book);
        item.save(itemTmp);
        return itemTmp;
    }

    private Item addOneTaskItem(Task task)
    {
        ItemDAO item = getItemDAO();
        Item itemTmp = new Item(item.nextId());
        itemTmp.setTask(task);
        item.save(itemTmp);
        return itemTmp;
    }
    public Item makeAvailable(Item item)
    {
        if(item.getState() == ItemState.NEW)
            item.available();

        return item;
    }

    /**
     * Εισάγει τα δοκιμαστικά δεδομένα.
     */
    public void prepareData()
    {
        // πριν εισάγουμε τα δεδομένα διαγράφουμε ότι υπάρχει
        eraseData();

        ContactDAO authorDAO = getAuthorDAO();
        authorDAO.save(new Contact(authorDAO.nextId(), "Κωνσταντίνος", "Γκαρτζονίκας"));
        authorDAO.save(new Contact(authorDAO.nextId(), "Παλτόγλου", "Αικατερίνη"));
        authorDAO.save(new Contact(authorDAO.nextId(), "Zafeiris", "Vasileios"));
        authorDAO.save(new Contact(authorDAO.nextId(), "Ευαγγέλου", "Παναγιώτης"));
        authorDAO.save(new Contact(authorDAO.nextId(), "Οικονόμου", "Βασίλειος"));




        NoteDAO bookDao = getBookDAO();

        bookDao.save(new Note(bookDao.nextId(), "Super market","Γαλα,ψωμι,τυρι...", new ISBN("123456"), "978-3-16", 2012));
        bookDao.save(new Note(bookDao.nextId(), "Διάβασμα", "ΤΕΧΝΟΛΟΓΙΑ ΛΟΓΙΣΜΙΚΟΥ,ΕΡΓΑΣΙΑ", new ISBN("738912"), "123-4-56", 2000));
        bookDao.save(new Note(bookDao.nextId(), "Προφορική εξέταση Παρασκευή 19:30", "Όλα θα πάνε καλα!", new ISBN("3"), "554-34534", 1999));
        bookDao.save(new Note(bookDao.nextId(), "Προγραμμα εξεταστικης", "Δεν βγαίνει", new ISBN("2"), "654-4567", 2004));
        bookDao.save(new Note(bookDao.nextId(), "Εργασίες εξαμήνου", "Πολλές", new ISBN("1"), "456-6546", 2005));
        bookDao.save(new Note(bookDao.nextId(), "Συμπέρασματα", "Κανενα συμπέρασμα", new ISBN("3"), "554-34534", 1999));

        addOneBookItem(bookDao.find(3)).available();
        addOneBookItem(bookDao.find(3)).available();

        addOneBookItem(bookDao.find(4)).available();
        addOneBookItem(bookDao.find(4)).available();

        addOneBookItem(bookDao.find(5)).available();


        //add a copy per book
        addOneBookItem(bookDao.find(1));
        addOneBookItem(bookDao.find(2));
        //publishers are auto informed about the added books




        //now, link authors with books
        authorDAO.find(4).addBook(bookDao.find(3));
        authorDAO.find(4).addBook(bookDao.find(4));
        authorDAO.find(4).addBook(bookDao.find(5));

        authorDAO.find(1).addBook(bookDao.find(1));
        authorDAO.find(2).addBook(bookDao.find(1));
        authorDAO.find(3).addBook(bookDao.find(1));

        authorDAO.find(3).addBook(bookDao.find(2));
        authorDAO.find(4).addBook(bookDao.find(2));





        TaskDAO taskDao = getTaskDAO();

        taskDao.save(new Task(taskDao.nextId(), "Εργασία Τεχνολογία Λογισμικού","Τελείωσε...10/10!!!!!", new ISBN("123456"), "978-3-16", 2012));
        taskDao.save(new Task(taskDao.nextId(), "Υπόλοιπες εργασίες", "Ολες τελειωμένες", new ISBN("738912"), "123-4-56", 2000));
        taskDao.save(new Task(taskDao.nextId(), "SOS", "Εξαιρετική εργασία.. Μπραβο μας", new ISBN("2"), "654-4567", 2004));
        taskDao.save(new Task(taskDao.nextId(), "Εργασίες Παρασκευης", "Τελειώνουν", new ISBN("1"), "456-6546", 2005));
        taskDao.save(new Task(taskDao.nextId(), "Σκούπισμα", "task content5", new ISBN("3"), "554-34534", 1999));
        taskDao.save(new Task(taskDao.nextId(), "Σφουγγάρισμα", "task content6", new ISBN("3"), "554-34534", 1999));

        addOneTaskItem(taskDao.find(3)).available();
        addOneTaskItem(taskDao.find(3)).available();

        addOneTaskItem(taskDao.find(4)).available();
        addOneTaskItem(taskDao.find(4)).available();

        addOneTaskItem(taskDao.find(5)).available();


        //add a copy per book
        addOneTaskItem(taskDao.find(1));
        addOneTaskItem(taskDao.find(2));



    }

    /**
     * Επιστρέφει το DAO των συγγραφέων.
     * @return Το DAO των συγγραφέων
     */
    public abstract ContactDAO getAuthorDAO();

    /**
     * Επιστρέφει το DAO των βιβλίων.
     * @return Το DAO των βιβλίων
     */
    public abstract NoteDAO getBookDAO();

    public  abstract  TaskDAO getTaskDAO();



    /**
     * Επιστρέφει το DAO των αντιτύπων.
     * @return Το DAO των αντιτύπων
     */
    public abstract ItemDAO getItemDAO();

}
