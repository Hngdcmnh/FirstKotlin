package com.example.eurolight

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerViewTeamAdapter(var listTeam :ArrayList<Team>, val comunity : (teamName: String) -> Unit  ):RecyclerView.Adapter<RecyclerViewTeamAdapter.ViewHolder>() {
    lateinit var v:View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        v= LayoutInflater.from(parent.context).inflate(R.layout.item_team,parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listTeam.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*holder.onClick(v)*/
        var team1 = listTeam[position]
        holder.bindView(team1)


        v.setOnClickListener{
            Log.e("Keyy",listTeam[position].players.toString())

            comunity(position.toString())
//            comunity.passData2(position.toString())

            /*comunicator2 = Fragment() as Fragment_1
            comunicator2.passData2(position.toString())*/
        }
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        var imgView = v.findViewById<ImageView>(R.id.imgViewItem)
        var teamName = v.findViewById<TextView>(R.id.nameCountry)
        fun bindView(team1:Team)
        {
            teamName.text =team1.name
            Picasso.get().load(team1.FlagUrl).into(imgView)
        }

        init {
            v

        }
    }


}



