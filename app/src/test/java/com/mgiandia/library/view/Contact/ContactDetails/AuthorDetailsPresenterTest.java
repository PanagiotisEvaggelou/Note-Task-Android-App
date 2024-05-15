package com.mgiandia.library.view.Contact.ContactDetails;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.mgiandia.library.dao.Initializer;
import com.mgiandia.library.memorydao.MemoryInitializer;



public class AuthorDetailsPresenterTest
{
    private Initializer dataHelper;
    private ContactDetailsPresenter presenter;
    private ContactDetailsViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new ContactDetailsViewStub();
        view.setAttachedAuthorID(1);
        view.setPageName("page");
        presenter = new ContactDetailsPresenter(view, dataHelper.getAuthorDAO());
    }

    @Test
    public void toastTest()
    {
        presenter.onShowToast("test");
        Assert.assertEquals("test", view.getToast());
    }

    @Test
    public void editButton()
    {
        presenter.onStartEditButtonClick();
        Assert.assertEquals(view.getEditAuthor(), 1);
    }

    @Test
    public void showBooksButton()
    {
        presenter.onStartShowBooksButtonClick();
        Assert.assertEquals(view.getShowBooks(), 1);
    }
}
