package com.example.eurolight.Fragment

import androidx.constraintlayout.widget.ConstraintLayout

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eurolight.Object.Team
import com.example.eurolight.R
import com.squareup.picasso.Picasso

class RecyclerViewMyTeamAdapter(var listTeam :ArrayList<Team>):RecyclerView.Adapter<RecyclerViewMyTeamAdapter.ViewHolder>() {
    lateinit var v:View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        v= LayoutInflater.from(parent.context).inflate(R.layout.item_myteam,parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listTeam.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var team1 = listTeam[position]
        holder.bindView(team1)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        var flag = v.findViewById<ImageView>(R.id.myTeamFlag)
        fun bindView(team1: Team)
        {
             Picasso.get().load(team1.FlagUrl).into(flag)
        }
        init {
            v

        }
    }


}



