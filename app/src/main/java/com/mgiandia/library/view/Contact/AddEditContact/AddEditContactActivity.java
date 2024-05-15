package com.mgiandia.library.view.Contact.AddEditContact;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mgiandia.library.R;
import com.mgiandia.library.domain.AppConfig;
import com.mgiandia.library.memorydao.ContactDAOMemory;



public class AddEditContactActivity extends AppCompatActivity implements AddEditContactView
{
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(AddEditContactActivity.this)
        .setCancelable(true)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(R.string.ok, null).create().show();
    }

    /**
     * Το μήνυμα πoυ εμφανίζεται όταν τελειώνει
     * επιτυχώς ένα activity.
     * @param message Το μήνυμα που θα εμφανίσει
     */
    public void successfullyFinishActivity(String message)
    {
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(RESULT_OK, retData);
        finish();
    }

    /**
     * Επιστρέφει το πρώτο όνομα του συγγραφέα.
     * @return Το πρώτο όνομα του συγγραφέα
     */
    public String getFirstName()
    {
        return ((EditText)findViewById(R.id.edit_text_first_name)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το επώνυμο του συγγραφέα.
     * @return Το επώνυμο του συγγραφέα
     */
    public String getLastName()
    {
        return ((EditText)findViewById(R.id.edit_text_last_name)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το id του συγγραφέα.
     * @return Το id του συγγραφέα
     */
    public Integer getAttachedAuthorID()
    {
        return this.getIntent().hasExtra("author_id") ? this.getIntent().getExtras().getInt("author_id") : null;
    }

    /**
     * Θέτει το πρώτο όνομα του συγγραφέα.
     * @param value Το πρώτο όνομα του συγγραφέα
     */
    public void setFirstName(String value)
    {
        ((EditText)findViewById(R.id.edit_text_first_name)).setText(value);
    }

    /**
     * Θέτει το επώνυμο του συγγραφέα.
     * @param value Το επώνυμο του συγγραφέα
     */
    public void setLastName(String value)
    {
        ((EditText)findViewById(R.id.edit_text_last_name)).setText(value);
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
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        AppConfig.getInstance().setWorkingWithTasks("c");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_author);
        final AddEditContactPresenter presenter = new AddEditContactPresenter(this, new ContactDAOMemory());

        findViewById(R.id.complete_registration_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                presenter.onSaveAuthor();
            }
        });
    }
}
