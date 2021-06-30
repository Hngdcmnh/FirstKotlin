package com.example.eurolight.Fragment

import android.util.Log
import com.example.eurolight.Object.News

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.eurolight.MatchListener
import com.example.eurolight.Object.Match
import com.example.eurolight.R
import com.squareup.picasso.Picasso

class RecyclerViewNewsAdapter(var listNews : ArrayList<News>): RecyclerView.Adapter<RecyclerViewNewsAdapter.ViewHolderMatch>() {
    lateinit var v: View
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolderMatch {
        v = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolderMatch(v)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: ViewHolderMatch, position: Int) {
        var news = listNews[position]
        holder.bindView(news)
    }


    class ViewHolderMatch(v: View):RecyclerView.ViewHolder(v){

        var img = v.findViewById<ImageView>(R.id.imgv_news)
        var content = v.findViewById<TextView>(R.id.txtv_news)

        fun bindView(news :News)
        {
            content.text = news.content
            news.image?.let { img.setImageResource(it) }
            Log.e(FragmentNews::class.java.simpleName,news.content)
        }

        init{
            v
        }

    }

}
