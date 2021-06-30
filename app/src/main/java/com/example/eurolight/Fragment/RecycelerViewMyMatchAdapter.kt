package com.example.eurolight.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.eurolight.Object.Match
import com.example.eurolight.R
import com.squareup.picasso.Picasso

class RecyclerViewMyMatchAdapter(var listMyMatch :ArrayList<Match>):RecyclerView.Adapter<RecyclerViewMyMatchAdapter.ViewHolder>() {
    lateinit var v: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        v = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listMyMatch.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        var match1 = listMyMatch[position]
        holder.bindView(match1)

    }

    class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        var imgTeam1 = v.findViewById<ImageView>(R.id.imgViewMatch1)
        var imgTeam2 = v.findViewById<ImageView>(R.id.imgViewMatch2)
        var matchDay = v.findViewById<TextView>(R.id.matchDay)
        var matchHour = v.findViewById<TextView>(R.id.matchHour)
        var nameTeam1 = v.findViewById<TextView>(R.id.nameTeam1)
        var nameTeam2 = v.findViewById<TextView>(R.id.nameTeam2)
        var backGround = v.findViewById<ConstraintLayout>(R.id.iteamMatch)
        var iconCheck = v.findViewById<ImageView>(R.id.iconCheck)
        fun bindView(match: Match)
        {
            Picasso.get().load(match.team1.FlagUrl).into(imgTeam1)
            Picasso.get().load(match.team2.FlagUrl).into(imgTeam2)
            matchDay.text = match.matchDay
            matchHour.text=match.matchHour
            nameTeam1.text = match.team1.name
            nameTeam2.text = match.team2.name

        }

        init{
            v
        }



    }




}