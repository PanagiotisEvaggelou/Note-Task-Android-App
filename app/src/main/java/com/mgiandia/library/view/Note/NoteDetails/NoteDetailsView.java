package com.mgiandia.library.view.Note.NoteDetails;

import java.util.List;



public interface NoteDetailsView
{
    int getAttachedBookID();


    /**
     * Θέτει τον τίτλο του βιβλίου.
     * @param value Ο τίτλος του βιβλίου.
     */
    void setBookTitle(String value);

    void setContent(String value);

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

    void setAuthors(List<String> authorIds, List<String> authorNames);
}
