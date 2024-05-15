package com.mgiandia.library.view.Note.Search;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.mgiandia.library.dao.NoteDAO;
import com.mgiandia.library.memorydao.NoteDAOMemory;

public class NoteSearchViewModel extends ViewModel {

    private NoteSearchPresenter presenter;

    public NoteSearchViewModel() {
        presenter = new NoteSearchPresenter();
        NoteDAO bookDAO = new NoteDAOMemory();
        presenter.setBookDAO(bookDAO);
    }

    public NoteSearchPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("BookSearchVM", "onCleared");
        // release resources
    }
}

