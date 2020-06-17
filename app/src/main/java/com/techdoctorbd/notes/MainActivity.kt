package com.techdoctorbd.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.RealmResults
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var addNotes : FloatingActionButton
    private lateinit var notesRecyclerView: RecyclerView
    private lateinit var noteList : ArrayList<NoteItem>
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init Views
        realm = Realm.getDefaultInstance()
        addNotes = findViewById(R.id.floating_button_home)
        notesRecyclerView = findViewById(R.id.recyclerView_home)

        //add notes button click action

        addNotes.setOnClickListener{
            startActivity(Intent(this,AddNotesActivity::class.java))
        }

        notesRecyclerView.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)

    }

    override fun onStart() {
        super.onStart()
        getAllNotes()
    }

    fun getAllNotes(){
        noteList = ArrayList()

        val result: RealmResults<NoteItem> = realm.where<NoteItem>(NoteItem::class.java).findAll()
        notesRecyclerView.adapter = NotesListAdapter(this,result)
        notesRecyclerView.adapter!!.notifyDataSetChanged()
    }
}