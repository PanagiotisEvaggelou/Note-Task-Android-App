package com.mgiandia.library.view.Contact.ContactDetails;



public class ContactDetailsViewStub implements ContactDetailsView
{
    private String firstName, lastName, booksWritten, id, toast, pageName;
    private int attachedAuthorID, editAuthor, showBooksAuthor;

    public ContactDetailsViewStub()
    {
        firstName = lastName = booksWritten = id = toast = pageName = "";
        attachedAuthorID = editAuthor = showBooksAuthor = 0;
    }

    public void setAttachedAuthorID(int id) {
        attachedAuthorID = id;
    }

    @Override
    public int getAttachedAuthorID() {
        return attachedAuthorID;
    }

    public String getID() {
        return id;
    }

    @Override
    public void setID(String value) {
        id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String value) {
        firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String value) {
        lastName = value;
    }

    public String getBooksWritten() {
        return booksWritten;
    }

    @Override
    public void setBooksWritten(String value) {
        booksWritten = value;
    }

    @Override
    public void setPageName(String value) {
        pageName = value;
    }

    public int getEditAuthor() {
        return editAuthor;
    }

    @Override
    public void startEdit(int authorID) {
        editAuthor = authorID;
    }

    public int getShowBooks() {
        return showBooksAuthor;
    }

    @Override
    public void startShowBooks(int authorID) {
        showBooksAuthor = authorID;
    }

    public String getToast() {
        return toast;
    }

    @Override
    public void showToast(String value) {
        toast = value;
    }
}
