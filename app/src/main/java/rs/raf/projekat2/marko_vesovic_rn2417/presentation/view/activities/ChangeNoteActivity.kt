package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_change_note.*
import rs.raf.projekat2.marko_vesovic_rn2417.R

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ChangeNoteActivity : AppCompatActivity(R.layout.activity_change_note) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        lateinit var title: String
        lateinit var content: String
        var archived = false
        var id: Long = 0

        intent?.let {
            title = it.getStringExtra("title")
            content = it.getStringExtra("content")
            archived = it.getBooleanExtra("archived", false)
            id = it.getLongExtra("id", 0)
        }

        noteTitleEditTextChange.setText(title)
        noteContentEditTextChange.setText(content)


        changeButtonChange.setOnClickListener {
            val returnTitle = noteTitleEditTextChange.text.toString()
            val returnContent = noteContentEditTextChange.text.toString()
            val returnArchived = archived
            val returnId = id
            val returnIntent = Intent()
            returnIntent.putExtra("id", returnId)
            returnIntent.putExtra("title", returnTitle)
            returnIntent.putExtra("content", returnContent)
            returnIntent.putExtra("archived", returnArchived)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        cancelButtonChange.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

}