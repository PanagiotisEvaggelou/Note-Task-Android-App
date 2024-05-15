package com.mgiandia.library.view.Task.Search;

import com.mgiandia.library.dao.TaskDAO;
import com.mgiandia.library.domain.Task;

import java.util.HashSet;
import java.util.Set;

public class TaskSearchPresenter {
    private TaskDAO bookDAO;
    private TaskSearchView view;
    private Set<Task> searchResult = new HashSet<>();

    public TaskSearchPresenter() {
    }

    public TaskDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(TaskDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void setView(TaskSearchView view) {
        this.view = view;
    }

    public void search(String titleCriterion, String authorCriterion) {

        searchResult.clear();
        if (isEmpty(titleCriterion) && isEmpty(authorCriterion)){
            searchResult.addAll(bookDAO.findAll());
        }
        Set<Task> titleSearchResult = new HashSet<>();
        Set<Task> authorSearchResult = new HashSet<>();
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

    public Set<Task> getSearchResult() {
        return searchResult;
    }

    private boolean isEmpty(String searchTerm){
        return searchTerm == null || searchTerm.isEmpty();
    }
}
