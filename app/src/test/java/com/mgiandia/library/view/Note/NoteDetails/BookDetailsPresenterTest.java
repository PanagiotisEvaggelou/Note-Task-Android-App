package com.mgiandia.library.view.Note.NoteDetails;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.mgiandia.library.dao.Initializer;
import com.mgiandia.library.memorydao.MemoryInitializer;



public class BookDetailsPresenterTest
{
    private Initializer dataHelper;
    private NoteDetailsPresenter presenter;
    private NoteDetailsViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new NoteDetailsViewStub();
        view.setAttachedBookID(1);
        view.setPageName("page");
        presenter = new NoteDetailsPresenter(view, dataHelper.getBookDAO());
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
        Assert.assertEquals(view.getEditBook(), 1);
    }
}
