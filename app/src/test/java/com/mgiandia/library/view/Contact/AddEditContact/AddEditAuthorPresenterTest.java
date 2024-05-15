package com.mgiandia.library.view.Contact.AddEditContact;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.mgiandia.library.dao.Initializer;
import com.mgiandia.library.memorydao.ContactDAOMemory;
import com.mgiandia.library.memorydao.MemoryInitializer;



public class AddEditAuthorPresenterTest
{
    private Initializer dataHelper;
    private AddEditContactPresenter presenter;
    private AddEditContactViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new AddEditContactViewStub();
    }

    @Test
    public void testAddNew()
    {
        presenter = new AddEditContactPresenter(view, new ContactDAOMemory());

        presenter.onSaveAuthor();
        view.setFirstName("1");
        Assert.assertEquals(view.getErrorTitle(), "Σφάλμα!");
        Assert.assertEquals(view.getErrorMessage(), "Συμπληρώστε 2 έως 15 χαρακτήρες στο όνομα.");

        view.setFirstName("first");
        view.setLastName("1");
        presenter.onSaveAuthor();
        Assert.assertEquals(view.getErrorTitle(), "Σφάλμα!");
        Assert.assertEquals(view.getErrorMessage(), "Συμπληρώστε 2 έως 15 χαρακτήρες στο επώνυμο.");

        view.setLastName("last");
        presenter.onSaveAuthor();

        Assert.assertEquals(view.getFinishMessage(), "Επιτυχής Εγγραφή του 'last first'!");
    }

    @Test
    public void testUpdateExisting()
    {
        view.setAttachedAuthorID(1);
        presenter = new AddEditContactPresenter(view, new ContactDAOMemory());

        presenter.onSaveAuthor();

        Assert.assertEquals(view.getFinishMessage(), "Επιτυχής Τροποποίηση του '"+(new ContactDAOMemory().find(1).getLastName())+" "+(new ContactDAOMemory().find(1).getFirstName())+"'!");
    }
}
