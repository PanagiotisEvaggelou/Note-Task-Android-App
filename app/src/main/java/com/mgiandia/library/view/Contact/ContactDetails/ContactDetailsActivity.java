package com.mgiandia.library.view.Contact.ContactDetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mgiandia.library.R;
import com.mgiandia.library.domain.AppConfig;
import com.mgiandia.library.memorydao.ContactDAOMemory;
import com.mgiandia.library.view.Contact.AddEditContact.AddEditContactActivity;
import com.mgiandia.library.view.Note.ManageNotes.ManageNotesActivity;



public class ContactDetailsActivity extends AppCompatActivity implements ContactDetailsView
{
    ContactDetailsPresenter presenter;

    /**
     * Ξεκινάει το activity ManageBooksActivity
     * με παράμετρο το id του συγγραφέα.
     * @param authorID Το id του συγγραφέα
     */
    public void startShowBooks(int authorID)
    {
        Intent intent = new Intent(this, ManageNotesActivity.class);
        intent.putExtra("author_id", authorID);
        startActivityForResult(intent, 100);
    }

    /**
     * Ξεκινάει το activity AddEditAuthorActivity
     * με παράμετρο το id του συγγραφέα.
     * @param authorID Το id του συγγραφέα
     */
    public void startEdit(int authorID)
    {
        Intent intent = new Intent(this, AddEditContactActivity.class);
        intent.putExtra("author_id", authorID);
        startActivityForResult(intent, 2);
    }

    /**
     * Επιστρέφει το id του συγγραφέα.
     * @return Το id του συγγραφέα
     */
    public int getAttachedAuthorID()
    {
        return this.getIntent().hasExtra("author_id") ? this.getIntent().getExtras().getInt("author_id") : null;
    }

    /**
     * Θέτει το πρώτο όνομα του συγγραφέα.
     * @param value Το πρώτο όνομα του συγγραφέα
     */
    public void setFirstName(String value)
    {
        ((TextView)findViewById(R.id.text_first_name)).setText(value);
    }

    /**
     * Θέτει το επώνυμο του συγγραφέα.
     * @param value Το επώνυμο του συγγραφέα
     */
    public void setLastName(String value)
    {
        ((TextView)findViewById(R.id.text_last_name)).setText(value);
    }

    /**
     * Θέτει το όνομα της σελίδας.
     * @param value το όνομα της σελίδας
     */
    public void setPageName(String value)
    {
        getSupportActionBar().setTitle(value);
    }

    /**
     * Εμφανίζει ένα Toast.
     * @param value To περιεχόμενο που θα εμφανιστεί
     */
    public void showToast(String value)
    {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState Το αποθηκευμένο instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        AppConfig.getInstance().setWorkingWithTasks("c");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_details);
        presenter = new ContactDetailsPresenter(this, new ContactDAOMemory());

        findViewById(R.id.edit_user_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                presenter.onStartEditButtonClick();
            }
        });
    }

    /**
     * Ξανά δημιουργεί το activity με νεό instance.
     * Σε περίπτωση που ο ζητούμενος κωδικός είναι
     * 2 και ο κωδικός του αποτελέσματος είναι ok,
     * εμφανίζει ένα toast.
     * @param requestCode Ο ζητούμενος κωδικός
     * @param resultCode Ο κωδικός του αποτελέσματος
     * @param data Το intent
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2 && resultCode == Activity.RESULT_OK)
        {
            recreate();
            presenter.onShowToast(data.getStringExtra("message_to_toast"));
        }
        else if(requestCode == 100)
            recreate();
    }
}
