package com.mgiandia.library.view.Contact.AddEditContact;



public class AddEditContactViewStub implements AddEditContactView
{
    private String firstName, lastName, pageName, errorTitle, errorMessage, finishMessage;
    private Integer attachedAuthorID;

    private AddEditContactPresenter presenter;

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setAttachedAuthorID(Integer val)
    {
        attachedAuthorID = val;
    }

    public Integer getAttachedAuthorID()
    {
        return attachedAuthorID;
    }

    public void setFirstName(String value)
    {
        firstName = value;
    }

    public void setLastName(String value)
    {
        lastName = value;
    }

    public void setPageName(String value)
    {
        pageName = value;
    }

    public void setPresenter(AddEditContactPresenter presenter) {
        this.presenter = presenter;
    }

    public AddEditContactPresenter getPresenter() {
        return presenter;
    }

    public AddEditContactViewStub()
    {
        firstName = lastName = pageName = errorTitle = errorMessage = finishMessage = "";
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
