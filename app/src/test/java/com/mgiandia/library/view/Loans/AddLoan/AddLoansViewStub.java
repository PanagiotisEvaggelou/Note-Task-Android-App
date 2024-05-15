package com.mgiandia.library.view.Loans.AddLoan;

import java.util.ArrayList;
import java.util.List;

import com.mgiandia.library.view.Contact.AddEditContact.AddEditContactPresenter;



public class AddLoansViewStub implements AddLoansView
{
    private String borrowerID, pageName, errorTitle, errorMessage, finishMessage;
    private int attachedBorrowerID, selectedBookId;
    private List<String> bookList;

    private AddEditContactPresenter presenter;

    public void setAttachedBorrowerID(int val)
    {
        attachedBorrowerID = val;
    }

    public void setSelectedBookId(int value)
    {
        selectedBookId = value;
    }

    public void setBorrowerId(String value)
    {
        borrowerID = value;
    }

    public int getAttachedBorrowerID()
    {
        return attachedBorrowerID;
    }

    public int getSelectedBookId()
    {
        return selectedBookId;
    }

    public void setPageName(String value)
    {
        pageName = value;
    }

    public void setPresenter(AddEditContactPresenter presenter) {
        this.presenter = presenter;
    }

    public void setBookList(List<String> value)
    {
        bookList = value;
    }

    public AddEditContactPresenter getPresenter() {
        return presenter;
    }

    public AddLoansViewStub()
    {
        borrowerID = pageName = errorTitle = errorMessage = finishMessage = "";
        bookList = new ArrayList<>();
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

    public List<String> getBookList()
    {
        return bookList;
    }

    public void successfullyAddLoanAndFinishActivity(String message)
    {
        finishMessage = message;
    }

    public void showErrorMessage(String title, String message)
    {
        errorTitle = title;
        errorMessage = message;
    }

    public void showAlert(String title, String message)
    {
        errorTitle = title;
        errorMessage = message;
    }
}
