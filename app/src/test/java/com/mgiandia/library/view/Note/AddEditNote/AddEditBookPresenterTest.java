package com.mgiandia.library.view.Note.AddEditNote;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import com.mgiandia.library.dao.Initializer;
import com.mgiandia.library.memorydao.ContactDAOMemory;
import com.mgiandia.library.memorydao.NoteDAOMemory;
import com.mgiandia.library.memorydao.ItemDAOMemory;
import com.mgiandia.library.memorydao.MemoryInitializer;



public class AddEditBookPresenterTest
{
    private Initializer dataHelper;
    private AddEditNotePresenter presenter;
    private AddEditBookViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new AddEditBookViewStub();
    }

    @Test
    public void testAddNew()
    {
        presenter = new AddEditNotePresenter(view, new NoteDAOMemory(), new PublisherDAOMemory(), new ContactDAOMemory(), new ItemDAOMemory());

        presenter.onSaveBook();
        view.setBookTitle("1");
        Assert.assertEquals(view.getErrorTitle(), "Σφάλμα!");
        Assert.assertEquals(view.getErrorMessage(), "Συμπληρώστε 2 έως 15 χαρακτήρες στον Τίτλο.");

        view.setBookTitle("title");
        view.setISBN("1");
        presenter.onSaveBook();
        Assert.assertEquals(view.getErrorTitle(), "Σφάλμα!");
        Assert.assertEquals(view.getErrorMessage(), "Συμπληρώστε 2 έως 15 χαρακτήρες στο ISBN.");

        view.setISBN("123456789");
        view.setPublication("1");
        presenter.onSaveBook();
        Assert.assertEquals(view.getErrorTitle(), "Σφάλμα!");
        Assert.assertEquals(view.getErrorMessage(), "Συμπληρώστε 2 έως 15 χαρακτήρες στη Δημοσίευση.");

        view.setPublication("123456789");
        view.setYear("123A");
        presenter.onSaveBook();
        Assert.assertEquals(view.getErrorTitle(), "Σφάλμα!");
        Assert.assertEquals(view.getErrorMessage(), "Συμπληρώστε ακριβώς 4 αριθμητικά ψηφία το Έτος.");

        view.setYear("1234");
        view.setPublisherPosition(null);
        presenter.onSaveBook();
        Assert.assertEquals(view.getErrorTitle(), "Σφάλμα!");
        Assert.assertEquals(view.getErrorMessage(), "Επιλέξτε Εκδοτικό Οίκο.");

        view.setPublisherPosition(1);
        presenter.onSaveBook();
        Assert.assertEquals(view.getErrorTitle(), "Σφάλμα!");
        Assert.assertEquals(view.getErrorMessage(), "Επιλέξτε τουλάχιστον ένα Συγγραφέα.");

        view.setAuthorPositions(Arrays.asList(1));
        presenter.onSaveBook();

        Assert.assertEquals(view.getFinishMessage(), "Επιτυχής Προσθήκη του Βιβλίου 'title'!");
    }

    @Test
    public void testUpdateExisting()
    {
        view.setAttachedBookID(1);
        presenter = new AddEditNotePresenter(view, dataHelper.getBookDAO(), dataHelper.getPublisherDAO(), dataHelper.getAuthorDAO(), dataHelper.getItemDAO());

        presenter.onSaveBook();

        Assert.assertEquals(view.getFinishMessage(), "Επιτυχής Τροποποίηση του Βιβλίου '"+(new NoteDAOMemory().find(1).getTitle())+"'!");
    }
}
