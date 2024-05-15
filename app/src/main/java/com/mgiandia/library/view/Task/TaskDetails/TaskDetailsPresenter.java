package com.mgiandia.library.view.Task.TaskDetails;

import java.util.ArrayList;

import com.mgiandia.library.dao.TaskDAO;
import com.mgiandia.library.domain.Contact;
import com.mgiandia.library.domain.Task;



public class TaskDetailsPresenter
{
    private TaskDetailsView view;
    private Task attachedBook;

    /**
     * Δημιουργεί τις λεπτομέρειες των βιβλίων
     * books.
     * @param view Ένα instance του view
     * @param books Ένα instance του book
     */
    public TaskDetailsPresenter(TaskDetailsView view, TaskDAO books)
    {
        this.view = view;

        attachedBook = books.find(view.getAttachedBookID());

        view.setBookTitle(attachedBook.getTitle());
        view.setContent(attachedBook.getContent());

        ArrayList<String> author_ids = new ArrayList<>(), author_names = new ArrayList<>();

        for(int i = 0; i < attachedBook.getAuthors().size(); i++)
            author_ids.add("#"+(i+1));

        for(Contact author : attachedBook.getAuthors())
            author_names.add(author.getLastName()+" "+author.getFirstName());

        view.setAuthors(author_ids, author_names);

    }

    /**
     * Ξεκινάει να τροποποιεί το βιβλίο
     */
    public void onStartEditButtonClick()
    {
        view.startEdit(attachedBook.getId());
    }

    /**
     * Εμφανίζει ένα μήνυμα με περιεχόμενο value.
     * @param value Το περιεχόμενο του μηνύματος
     */
    public void onShowToast(String value)
    {
        view.showToast(value);
    }
}
