package com.example.eurolight

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerViewMatchAdapter(var listMatch:ArrayList<Match>, var matchListener: MatchListener): RecyclerView.Adapter<RecyclerViewMatchAdapter.ViewHolderMatch>() {
    lateinit var v: View
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RecyclerViewMatchAdapter.ViewHolderMatch {
        v = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return ViewHolderMatch(v,matchListener)
    }

    override fun getItemCount(): Int {
        return listMatch.size
    }

    override fun onBindViewHolder(holder: RecyclerViewMatchAdapter.ViewHolderMatch, position: Int) {
        var match1 = listMatch[position]
        holder.bindView(match1)

    }


    fun getSelectedMatchs(): ArrayList<Match> {
        val selectedMatchs: ArrayList<Match> = ArrayList()
        for (match1 in listMatch) {
            if (match1.isSelected) {
                selectedMatchs.add(match1)
            }
        }
        return selectedMatchs
    }

    class ViewHolderMatch(v: View,matchListener: MatchListener):RecyclerView.ViewHolder(v){
        var imgTeam1 = v.findViewById<ImageView>(R.id.imgViewMatch1)
        var imgTeam2 = v.findViewById<ImageView>(R.id.imgViewMatch2)
        var matchDay = v.findViewById<TextView>(R.id.matchDay)
        var matchHour = v.findViewById<TextView>(R.id.matchHour)
        var nameTeam1 = v.findViewById<TextView>(R.id.nameTeam1)
        var nameTeam2 = v.findViewById<TextView>(R.id.nameTeam2)
        var backGround = v.findViewById<ConstraintLayout>(R.id.iteamMatch)
        var iconCheck = v.findViewById<ImageView>(R.id.iconCheck)
        var z= matchListener
        fun bindView(match:Match)
        {
            Picasso.get().load(match.team1.FlagUrl).into(imgTeam1)
            Picasso.get().load(match.team2.FlagUrl).into(imgTeam2)
            matchDay.text = match.matchDay
            matchHour.text=match.matchHour
            nameTeam1.text = match.team1.name
            nameTeam2.text = match.team2.name

            if(match.isSelected)
            {
                backGround.setBackgroundResource(R.drawable.item_match_selected)
                iconCheck.setVisibility(View.VISIBLE)
            }
            else
            {
                backGround.setBackgroundResource(R.drawable.rounded_conner_4)
                iconCheck.setVisibility(View.GONE)
            }

            backGround.setOnClickListener(View.OnClickListener(){
                if(match.isSelected)
                {
                    backGround.setBackgroundResource(R.drawable.rounded_conner_4)
                    iconCheck.setVisibility(View.GONE)
                    match.isSelected=false
                    z.onMatchAction(false)
                }
                else
                {
                    backGround.setBackgroundResource(R.drawable.item_match_selected)
                    iconCheck.setVisibility(View.VISIBLE)
                    match.isSelected=true
                    z.onMatchAction(true)
                }

            })

        }



        init{
            v
        }



    }

}
