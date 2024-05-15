package com.mgiandia.library.view.Task.TaskDetails;

import java.util.List;



public interface TaskDetailsView
{
    int getAttachedBookID();


    /**
     * Θέτει τον τίτλο του βιβλίου.
     * @param value Ο τίτλος του βιβλίου.
     */
    void setBookTitle(String value);

    void setContent(String value);

    /**
     * Θέτει τους συγγραφείς του βιβλίου.
     * @param author_ids Τα id των συγγραφέων
     * @param author_names Τα ονόματα των συγγραφέων
     */
    void setAuthors(List<String> author_ids, List<String> author_names);

    /**
     * Ξεκινάει να τροποποιεί το βιβλίο
     * με id bookID.
     * @param bookID Το id του βιβλίου που θα τροποποιηθεί
     */
    void startEdit(int bookID);

    /**
     * Εμφανίζει ένα Toast.
     * @param value Το περιεχόμενο που θα εμφανιστεί
     */
    void showToast(String value);
}
