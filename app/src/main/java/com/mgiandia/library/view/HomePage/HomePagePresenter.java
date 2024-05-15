package com.mgiandia.library.view.HomePage;



public class HomePagePresenter
{
    private HomePageView view;

    /**
     * Αρχικοποιεί τον Presenter.
     * @param view Ένα instance του view
     */
    public HomePagePresenter(HomePageView view)
    {
        this.view = view;
    }


    /**
     * Όταν πραγματοποιείται click στο ManageBooksActivity activity
     * ο χρήστης μεταφέρεται σε αυτό από την αρχική σελίδα.
     */
    void onManageBooks()
    {
        view.manageBooks();
    }

    /**
     * Όταν πραγματοποιείται click στο ManageAuthorsActivity activity
     * ο χρήστης μεταφέρεται σε αυτό από την αρχική σελίδα.
     */
    void onManageAuthors()
    {
        view.manageAuthors();
    }

    /**
     * Όταν πραγματοποιείται click στο ManageBooksActivity activity
     * ο χρήστης μεταφέρεται σε αυτό από την αρχική σελίδα. Επίσης αν
     * ελέγχεται αν πρέπει να φορτωθούν τα βιβλία.
     */
    void onManageItems()
    {
        view.manageItems();
    }

    void onManageTasks() { view.manageTasks(); }
}
