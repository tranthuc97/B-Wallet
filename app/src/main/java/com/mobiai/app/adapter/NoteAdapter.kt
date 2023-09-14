package com.mobiai.app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobiai.app.db.notes.Note
import com.mobiai.databinding.ItemNoteBinding
import java.text.SimpleDateFormat
import java.util.Locale

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notes: List<Note> = listOf()
    private var onItemClickListener: ((Note) -> Unit)? = null

    fun setOnItemClickListener(listener: (Note) -> Unit) {
        onItemClickListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNotes(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val formattedDate = dateFormat.format(note.date)
            binding.textViewTitle.text = note.title
            binding.textViewDate.text = "Date: $formattedDate"
            if (note.content.length >= 50) {
                binding.textViewContent.text = note.content+"..."
            }else{
                binding.textViewContent.text = note.content
            }
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(note)
            }
        }

    }
}
