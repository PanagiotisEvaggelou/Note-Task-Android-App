package com.mgiandia.library.view.Task.Search;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.mgiandia.library.dao.TaskDAO;
import com.mgiandia.library.memorydao.TaskDAOMemory;

public class TaskSearchViewModel extends ViewModel {

    private TaskSearchPresenter presenter;

    public TaskSearchViewModel() {
        presenter = new TaskSearchPresenter();
        TaskDAO bookDAO = new TaskDAOMemory();
        presenter.setBookDAO(bookDAO);
    }

    public TaskSearchPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("BookSearchVM", "onCleared");
        // release resources
    }
}

