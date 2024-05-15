package com.mgiandia.library.view.Note.ManageNotes;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.mgiandia.library.dao.Initializer;
import com.mgiandia.library.memorydao.MemoryInitializer;



public class ManageBooksPresenterTest
{
    private Initializer dataHelper;
    private ManageNotesPresenter presenter;
    private ManageNotesViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new ManageNotesViewStub();
    }

    @Test
    public void itemListClicks()
    {
        view.setAttachedAuthorID(1);
        view.setAttachedPublisherID(1);
        presenter = new ManageNotesPresenter(view, dataHelper.getBookDAO(), dataHelper.getAuthorDAO(), dataHelper.getPublisherDAO());

        view.setShouldLoadItemsOnClick(false);
        Assert.assertFalse(view.shouldLoadItemsOnClick());
        view.setShouldLoadItemsOnClick(true);
        Assert.assertTrue(view.shouldLoadItemsOnClick());

        presenter.onClickItem(12);
        presenter.onClickItem(12);
        presenter.onClickItem(18);
        presenter.onClickItem(17);

        Assert.assertEquals(2, view.getTimesListClickedItem(12));
        Assert.assertEquals(1, view.getTimesListClickedItem(17));
        Assert.assertEquals(1, view.getTimesListClickedItem(18));

        Assert.assertEquals(0, view.getTimesClickedItem(12));
        Assert.assertEquals(0, view.getTimesClickedItem(17));
        Assert.assertEquals(0, view.getTimesClickedItem(18));
    }

    @Test
    public void itemClicks()
    {
        presenter = new ManageNotesPresenter(view, dataHelper.getBookDAO(), dataHelper.getAuthorDAO(), dataHelper.getPublisherDAO());

        presenter.onClickItem(12);
        presenter.onClickItem(12);
        presenter.onClickItem(18);
        presenter.onClickItem(17);

        Assert.assertEquals(2, view.getTimesClickedItem(12));
        Assert.assertEquals(1, view.getTimesClickedItem(17));
        Assert.assertEquals(1, view.getTimesClickedItem(18));

        Assert.assertEquals(0, view.getTimesListClickedItem(12));
        Assert.assertEquals(0, view.getTimesListClickedItem(17));
        Assert.assertEquals(0, view.getTimesListClickedItem(18));
    }

    @Test
    public void showToast()
    {
        presenter = new ManageNotesPresenter(view, dataHelper.getBookDAO(), dataHelper.getAuthorDAO(), dataHelper.getPublisherDAO());

        Assert.assertEquals("", view.getToast());
        presenter.onShowToast("hello");
        Assert.assertEquals("hello", view.getToast());
    }

    @Test
    public void sourceTestEmpty()
    {
        view.setAttachedAuthorID(1);
        presenter = new ManageNotesPresenter(view, dataHelper.getBookDAO(), dataHelper.getAuthorDAO(), dataHelper.getPublisherDAO());

        presenter.onLoadSource();
        Assert.assertEquals(1, view.getSource().size());
    }

    @Test
    public void sourceTestAuthor()
    {
        view.setAttachedAuthorID(1);
        presenter = new ManageNotesPresenter(view, dataHelper.getBookDAO(), dataHelper.getAuthorDAO(), dataHelper.getPublisherDAO());

        presenter.onLoadSource();
        Assert.assertEquals(1, view.getSource().size());
    }

    @Test
    public void sourceTestPublisher()
    {
        view.setAttachedPublisherID(1);
        presenter = new ManageNotesPresenter(view, dataHelper.getBookDAO(), dataHelper.getAuthorDAO(), dataHelper.getPublisherDAO());

        presenter.onLoadSource();
        Assert.assertEquals(1, view.getSource().size());
    }
    @Test
    public void startAdd()
    {
        presenter = new ManageNotesPresenter(view, dataHelper.getBookDAO(), dataHelper.getAuthorDAO(), dataHelper.getPublisherDAO());

        Assert.assertFalse(view.isNewAdded());
        presenter.onStartAddNew();
        Assert.assertTrue(view.isNewAdded());
    }
}
