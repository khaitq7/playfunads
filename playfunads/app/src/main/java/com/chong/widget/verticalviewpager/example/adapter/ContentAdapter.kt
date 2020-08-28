package com.chong.widget.verticalviewpager.example.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.chong.widget.verticalviewpager.example.R

class ContentAdapter(private val index: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContentView(LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val content = holder as ContentView
        content.textView.text = "$index content$position"
        if (index == 2) {
            content.textView.visibility = View.GONE
            content.imageView.visibility = View.VISIBLE
        } else {
            content.textView.visibility = View.VISIBLE
        }
        //        Log.i(TAG, "bind view " + index + "," + position);
    }

    override fun getItemCount(): Int {
        if (index == 2) {
            return 1//for img
        }
        return if (index % 2 == 0) {
            5
        } else 15
    }


    inner class ContentView(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView
        val imageView: ImageView

        init {
            textView = itemView.findViewById<View>(R.id.context_text) as TextView
            imageView = itemView.findViewById<View>(R.id.img) as ImageView
        }
    }

    companion object {
        private val TAG = "ContentAdapter"
    }

}
