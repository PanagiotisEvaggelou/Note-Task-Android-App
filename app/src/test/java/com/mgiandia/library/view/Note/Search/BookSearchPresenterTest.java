package com.mgiandia.library.view.Note.Search;

import static org.junit.Assert.*;

import com.mgiandia.library.dao.Initializer;
import com.mgiandia.library.memorydao.NoteDAOMemory;
import com.mgiandia.library.memorydao.MemoryInitializer;

import org.junit.Before;
import org.junit.Test;

public class BookSearchPresenterTest {

    private NoteSearchPresenter presenter;

    @Before
    public void setup(){
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        presenter = new NoteSearchPresenter();
        presenter.setBookDAO(new NoteDAOMemory());
    }

    @Test
    public void searchWithoutCriteria(){
        presenter.search(null, null);
        assertEquals(5, presenter.getSearchResult().size());

        presenter.search("", "");
        assertEquals(5, presenter.getSearchResult().size());
    }

    @Test
    public void searchWithSingleCriterion(){
        presenter.search("UML", "");
        assertEquals(2, presenter.getSearchResult().size());
    }

    @Test
    public void searchWithBothCriteria(){
        presenter.search("UML", "Fowler");
        assertEquals(2, presenter.getSearchResult().size());

        presenter.search("UML", "Doe");
        assertEquals(0, presenter.getSearchResult().size());
    }




}