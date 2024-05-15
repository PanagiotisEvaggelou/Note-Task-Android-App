package com.mgiandia.library.view.Task.Search;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mgiandia.library.R;
import com.mgiandia.library.domain.AppConfig;
import com.mgiandia.library.domain.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskSearchActivity extends AppCompatActivity implements TaskSearchView,
        TaskRecyclerViewAdapter.ItemSelectionListener {

    public static final String BOOK_TITLE_EXTRA = "book_title";
    public static final String AUTHOR_NAME_EXTRA = "author_name";
    public static final String BOOK_ID_RESULT = "book_id_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppConfig.getInstance().setWorkingWithTasks("t");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_search);

        TaskSearchViewModel viewModel =
                new ViewModelProvider(this).get(TaskSearchViewModel.class);
        viewModel.getPresenter().setView(this);

        // Execute book search on activity create
        if (savedInstanceState == null){
            Intent intent = getIntent();
            String titleCriterion = intent.getStringExtra(BOOK_TITLE_EXTRA);
            String authorCriterion = intent.getStringExtra(AUTHOR_NAME_EXTRA);
            viewModel.getPresenter().search(titleCriterion, authorCriterion);
            Log.d("BookSearchActivity", "Received search criteria: " + titleCriterion + " " + authorCriterion);
        }

        // ui initialization
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Task> bookList = new ArrayList<>(viewModel.getPresenter().getSearchResult());
        Log.d("BookSearchActivity", "Retrieved " + bookList.size() + " items");
        recyclerView.setAdapter(new TaskRecyclerViewAdapter(bookList, this));

    }

    @Override
    public void selectBook(Task b) {
        Intent intent = new Intent();
        intent.putExtra(BOOK_ID_RESULT, b.getId());
        setResult(RESULT_OK, intent);
        finish();
    }


}