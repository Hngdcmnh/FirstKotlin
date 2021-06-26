package com.example.eurolight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerViewMatchAdapter(var listMatch:ArrayList<Match>): RecyclerView.Adapter<RecyclerViewMatchAdapter.ViewHolderMatch>() {
    lateinit var v:View
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewMatchAdapter.ViewHolderMatch {
        v =LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)
        return ViewHolderMatch(v)
    }

    override fun getItemCount(): Int {
        return listMatch.size
    }

    override fun onBindViewHolder(holder: RecyclerViewMatchAdapter.ViewHolderMatch, position: Int) {
        var match1 = listMatch[position]
        holder.bindView(match1)
    }

    class ViewHolderMatch(v: View):RecyclerView.ViewHolder(v){
        var imgTeam1 = v.findViewById<ImageView>(R.id.imgViewMatch1)
        var imgTeam2 = v.findViewById<ImageView>(R.id.imgViewMatch2)
        var matchDay = v.findViewById<TextView>(R.id.matchDay)
        var matchHour = v.findViewById<TextView>(R.id.matchHour)

        fun bindView(match:Match)
        {
            Picasso.get().load(match.team1.FlagUrl).into(imgTeam1)
            Picasso.get().load(match.team2.FlagUrl).into(imgTeam2)
            matchDay.text = match.matchDay
            matchHour.text=match.matchHour
        }

        init{
            v
        }

    }

}