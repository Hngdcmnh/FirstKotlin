package com.example.eurolight.Fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eurolight.Object.Player
import com.example.eurolight.R
import com.squareup.picasso.Picasso

class RecyclerViewPlayerAdapter(var listPlayer: ArrayList<Player>):RecyclerView.Adapter<RecyclerViewPlayerAdapter.ViewHolderPlayer>() {
    lateinit var v: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPlayer {
        v= LayoutInflater.from(parent.context).inflate(R.layout.item_player,parent,false)
        return ViewHolderPlayer(v)
    }

    override fun getItemCount(): Int {
        Log.e("KEY",listPlayer.size.toString())
        return listPlayer.size
    }

    override fun onBindViewHolder(holder: ViewHolderPlayer, position: Int) {
        var player1 = listPlayer[position]
        v.setOnClickListener{

        }
        holder.bindView(player1)
    }

    class ViewHolderPlayer(v:View):RecyclerView.ViewHolder(v){
        var imagePlayer = v.findViewById<ImageView>(R.id.imdViewPlayer)

        var namePlayer = v.findViewById<TextView>(R.id.namePlayer)
        var positionPlayer = v.findViewById<TextView>(R.id.positionPlayer)

        fun bindView(player: Player)
        {
            positionPlayer.text = player.position
            namePlayer.text = player.name
            Picasso.get().load(player.imageUrl).into(imagePlayer)
        }
        init {
            v
        }
    }

}
