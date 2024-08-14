package com.test.font

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(
    private val context: Context,
    private val fontSelected: FontSelected,
    private val texts: List<String>,
    private val fonts: List<Int> // List of font resource IDs
) : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(texts[position], fonts[position],position)
    }

    override fun getItemCount(): Int = texts.size

    inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String, fontResId: Int,position: Int) {
            textView.text = text
            val typeface = ResourcesCompat.getFont(context, fontResId)
            textView.typeface = typeface
            textView.setOnClickListener {
                fontSelected.fontSelected(position)
            }
        }
    }
}
