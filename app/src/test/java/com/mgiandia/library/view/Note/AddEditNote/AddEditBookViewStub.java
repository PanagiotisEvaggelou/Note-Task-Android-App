package com.mgiandia.library.view.Note.AddEditNote;

import java.util.ArrayList;
import java.util.List;



public class AddEditBookViewStub implements AddEditTaskView
{
    private String title, isbn, year, publication, pageName, errorTitle, errorMessage, finishMessage;
    private Integer position, attachedBookID;
    private List<Integer> authorsPositions;
    private List<String> authorsNames, publishersNames;

    private AddEditNotePresenter presenter;

    public void setPresenter(AddEditNotePresenter presenter) {
        this.presenter = presenter;
    }

    public AddEditNotePresenter getPresenter() {
        return presenter;
    }

    public AddEditBookViewStub()
    {
        title = isbn = year = publication = pageName = errorTitle = errorMessage = finishMessage = "";
        authorsPositions = new ArrayList<Integer>();
        authorsNames = new ArrayList<String>();
        publishersNames = new ArrayList<String>();
    }

    public void setAttachedBookID(Integer val)
    {
        attachedBookID = val;
    }

    public List<String> getAuthorList()
    {
        return authorsNames;
    }

    public List<String> getPublisherList()
    {
        return publishersNames;
    }

    public String getPageName()
    {
        return pageName;
    }

    public String getErrorTitle()
    {
        return errorTitle;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public String getFinishMessage()
    {
        return finishMessage;
    }

    public String getBookTitle()
    {
        return title;
    }

    public Integer getPublisherPosition()
    {
        return position;
    }

    public String getISBN()
    {
        return isbn;
    }

    public String getPublication()
    {
        return publication;
    }

    public String getYear()
    {
        return year;
    }

    public List<Integer> getAuthorPositions()
    {
        return authorsPositions;
    }

    public Integer getAttachedBookID()
    {
        return attachedBookID;
    }

    public void setBookTitle(String value)
    {
        title = value;
    }

    public void setPublisherPosition(Integer value)
    {
        position = value;
    }

    public void setISBN(String value)
    {
        isbn = value;
    }

    public void setPublication(String value)
    {
        publication = value;
    }

    public void setYear(String value)
    {
        year = value;
    }

    public void setAuthorPositions(List<Integer> value)
    {
        authorsPositions = value;
    }

    public void setPageName(String value)
    {
        pageName = value;
    }

    public void setAuthorList(List<String> names)
    {
        authorsNames = names;
    }

    public void setPublisherList(List<String> names, String defaultName)
    {
        publishersNames = names;
    }

    public void successfullyFinishActivity(String message)
    {
        finishMessage = message;
    }

    public void showErrorMessage(String title, String message)
    {
        errorTitle = title;
        errorMessage = message;
    }
}
