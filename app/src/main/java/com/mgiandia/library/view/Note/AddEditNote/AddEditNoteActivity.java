package com.mgiandia.library.view.Note.AddEditNote;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mgiandia.library.R;
import com.mgiandia.library.domain.AppConfig;
import com.mgiandia.library.memorydao.ContactDAOMemory;
import com.mgiandia.library.memorydao.NoteDAOMemory;
import com.mgiandia.library.memorydao.ItemDAOMemory;
import com.mgiandia.library.view.Util.MultiSelectSpinner;

import java.util.ArrayList;
import java.util.List;



public class AddEditNoteActivity extends AppCompatActivity implements AddEditNoteView
{
    /**
     * Εμφανίζει ένα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(AddEditNoteActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    /**
     * Το μήνυμα που εμφανίζεται όταν τελειώνει
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
     * Επιστρέφει τον τίτλο του βιβλίου.
     * @return Ο τίτλος του βιβλίου
     */
    public String getBookTitle()
    {
        return ((EditText)findViewById(R.id.edit_text_book_title)).getText().toString().trim();
    }

    public String getContent()
    {
        return ((EditText)findViewById(R.id.edit_text_content)).getText().toString().trim();
    }


    /**
     * Επιστρέφει το id του βιβλίου.
     * @return Το id του βιβλίου
     */
    public Integer getAttachedBookID()
    {
        return this.getIntent().hasExtra("book_id") ? this.getIntent().getExtras().getInt("book_id") : null;
    }

    /**
     * Θέτει τον τίτλο του βιβλίου
     * @param value Ο τίτλος του βιβλίου
     */
    public void setBookTitle(String value)
    {
        ((EditText)findViewById(R.id.edit_text_book_title)).setText(value);
    }

    /**
     * Θέτει το content του βιβλίου
     * @param value Ο τίτλος του βιβλίου
     */
    public void setContent(String value)
    {
        ((EditText)findViewById(R.id.edit_text_content)).setText(value);
    }

    /**
     * Θέτει τις θέσεις των συγγραφέων
     * @param value Οι θέσεις των συγγραφέων.
     */
    public void setAuthorPositions(List<Integer> value)
    {
        for(int i = 0; i < value.size(); i++)
            value.set(i, value.get(i)-1);

        ((MultiSelectSpinner)findViewById(R.id.edit_text_authors)).setSelectedItems(value);
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
     * Θέτει την λίστα των συγγραφέων.
     * @param names Τα ονόματα των συγγραφέων
     */
    public void setAuthorList(List<String> names)
    {
        ((MultiSelectSpinner) findViewById(R.id.edit_text_authors)).setItems(names);
        setAuthorPositions(new ArrayList<Integer>());
    }

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        AppConfig.getInstance().setWorkingWithTasks("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_book);
        final AddEditNotePresenter presenter = new AddEditNotePresenter(this, new NoteDAOMemory(), new ContactDAOMemory(), new ItemDAOMemory());

        findViewById(R.id.complete_registration_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.onSaveBook();
            }
        });
    }
}
