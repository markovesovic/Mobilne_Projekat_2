package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_change_note.*
import kotlinx.android.synthetic.main.activity_new_note.*
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note

class NewNoteActivity: AppCompatActivity(R.layout.activity_new_note) {

    companion object {
        const val NOTE_TITLE_KEY = "note_title_key"
        const val NOTE_CONTENT_KEY = "note_content_key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {

        saveButton.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(NOTE_TITLE_KEY, noteTitleEditText.text.toString())
            returnIntent.putExtra(NOTE_CONTENT_KEY, noteContentEditText.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

}