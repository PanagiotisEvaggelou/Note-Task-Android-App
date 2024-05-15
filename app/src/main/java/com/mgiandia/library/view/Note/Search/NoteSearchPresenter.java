package com.mgiandia.library.view.Note.Search;

import com.mgiandia.library.dao.NoteDAO;
import com.mgiandia.library.domain.Note;

import java.util.HashSet;
import java.util.Set;

public class NoteSearchPresenter {
    private NoteDAO bookDAO;
    private NoteSearchView view;
    private Set<Note> searchResult = new HashSet<>();

    public NoteSearchPresenter() {
    }

    public NoteDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(NoteDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void setView(NoteSearchView view) {
        this.view = view;
    }

    public void search(String titleCriterion, String authorCriterion) {

        searchResult.clear();
        if (isEmpty(titleCriterion) && isEmpty(authorCriterion)){
            searchResult.addAll(bookDAO.findAll());
        }
        Set<Note> titleSearchResult = new HashSet<>();
        Set<Note> authorSearchResult = new HashSet<>();
        if (!isEmpty(titleCriterion)){
            titleSearchResult.addAll(bookDAO.findByTitle(titleCriterion));
        }
        if (!isEmpty(authorCriterion)){
            authorSearchResult.addAll(bookDAO.findByAuthorName(authorCriterion));
        }
        if (!isEmpty(titleCriterion) && !isEmpty(authorCriterion)){
            searchResult.addAll(titleSearchResult);
            searchResult.retainAll(authorSearchResult);
            return;
        }

        searchResult.addAll(titleSearchResult);
        searchResult.addAll(authorSearchResult);

    }

    public Set<Note> getSearchResult() {
        return searchResult;
    }

    private boolean isEmpty(String searchTerm){
        return searchTerm == null || searchTerm.isEmpty();
    }
}
