package com.mgiandia.library.view.Note.AddEditNote;



public interface AddEditNoteView
{
    String getBookTitle();
    String getContent();

    Integer getAttachedBookID();

    /**
     * Θέτει τον τίτλο του βιβλίου
     * @param value Ο τίτλος του βιβλίου
     */
    void setBookTitle(String value);

    /**
     * Θέτει το content του βιβλίου
     * @param value Ο τίτλος του βιβλίου
     */
    void setContent(String value);


    /**
     * Το μήνυμα που εμφανίζεται όταν τελειώνει
     * επιτυχώς ένα activity.
     * @param message Το μήνυμα που θα εμφανίσει
     */
    void successfullyFinishActivity(String message);

    /**
     * Το μήνυμα που εμφανίζεται σε
     * περίπτωση error.
     * @param title O τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    void showErrorMessage(String title, String message);
}
