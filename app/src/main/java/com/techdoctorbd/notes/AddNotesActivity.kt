package com.techdoctorbd.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm
import java.lang.Exception

class AddNotesActivity : AppCompatActivity() {

    private lateinit var edTitle:EditText
    private lateinit var edDescription:EditText
    private lateinit var saveButton:Button
    private lateinit var realm:Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        //init views
        realm = Realm.getDefaultInstance()
        edTitle = findViewById(R.id.title_add_notes)
        edDescription = findViewById(R.id.description_add_notes)
        saveButton = findViewById(R.id.button_add_notes)

        //save button on click action
        saveButton.setOnClickListener {
            saveNotesToDB()
        }
    }

    private fun saveNotesToDB() {

        try {
            //generate auto increment id
            
            realm.beginTransaction()

            val id = realm.where(NoteItem::class.java).max("id")
            val nextId:Int
            nextId = if (id == null){
                1
            }else{
                id.toInt()+1
            }

            val noteItem = NoteItem()
            noteItem.title = edTitle.text.toString()
            noteItem.description = edDescription.text.toString()
            noteItem.id = nextId
            noteItem.priority = "High"

            realm.copyToRealmOrUpdate(noteItem)
            realm.commitTransaction()

            Toast.makeText(this,"Note added successfully",Toast.LENGTH_SHORT).show()
            finish()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}