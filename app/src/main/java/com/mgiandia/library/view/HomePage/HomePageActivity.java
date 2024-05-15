package com.mgiandia.library.view.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mgiandia.library.R;
import com.mgiandia.library.memorydao.MemoryInitializer;
import com.mgiandia.library.view.Contact.ManageContacts.ManageContactsActivity;
import com.mgiandia.library.view.Note.ManageNotes.ManageNotesActivity;
import com.mgiandia.library.view.Task.ManageTasks.ManageTasksActivity;



public class HomePageActivity extends AppCompatActivity implements HomePageView
{
    private static boolean initialized = false;

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final HomePagePresenter presenter = new HomePagePresenter(this);

        findViewById(R.id.manage_books_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onManageBooks();
            }
        });

        findViewById(R.id.manage_authors_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onManageAuthors();
            }
        });


        findViewById(R.id.manage_tasks_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onManageTasks();
            }
        });

        if(!initialized)
        {
            new MemoryInitializer().prepareData();
            initialized = true;
        }
    }


    /**
     * Όταν πραγματοποιείται click στο ManageBooksActivity activity
     * ο χρήστης μεταφέρεται σε αυτό από την αρχική σελίδα.
     */
    public void manageBooks()
    {
        Intent intent = new Intent(HomePageActivity.this, ManageNotesActivity.class);
        startActivity(intent);
    }

    /**
     * Όταν πραγματοποιείται click στο ManageAuthorsActivity activity
     * ο χρήστης μεταφέρεται σε αυτό από την αρχική σελίδα.
     */
    public void manageAuthors()
    {
        Intent intent = new Intent(HomePageActivity.this, ManageContactsActivity.class);
        startActivity(intent);
    }

    /**
     * Όταν πραγματοποιείται click στο ManageBooksActivity activity
     * ο χρήστης μεταφέρεται σε αυτό από την αρχική σελίδα. Επίσης αν
     * ελέγχεται αν πρέπει να φορτωθούν τα βιβλία.
     */
    public void manageItems()
    {
        Intent intent = new Intent(HomePageActivity.this, ManageNotesActivity.class);
        intent.putExtra("should_load_items", 1);
        startActivity(intent);
    }

    /**
     * Όταν πραγματοποιείται click στο ManageAuthorsActivity activity
     * ο χρήστης μεταφέρεται σε αυτό από την αρχική σελίδα.
     */
    public void manageTasks()
    {
        Intent intent = new Intent(HomePageActivity.this, ManageTasksActivity.class);
        startActivity(intent);
    }
}
