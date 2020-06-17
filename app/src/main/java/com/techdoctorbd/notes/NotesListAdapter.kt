package com.techdoctorbd.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults
import kotlinx.android.synthetic.main.notes_item_layout.view.*

class NotesListAdapter(private val context: Context?,private val notesList:RealmResults<NoteItem>):RecyclerView.Adapter<NotesListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.stag_id.text = notesList[position]!!.id.toString()
        holder.itemView.stag_Title.text = notesList[position]!!.title
        holder.itemView.stag_desc.text = notesList[position]!!.description
    }

    class ViewHolder(view: View?):RecyclerView.ViewHolder(view!!)
}