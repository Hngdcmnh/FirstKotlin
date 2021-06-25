package com.example.eurolight

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class Fragment_1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var recyclerView : RecyclerView = view.findViewById(R.id.recyclerViewTeam)
        var recyclerViewAdapter1 = RecyclerViewAdapter1(Model.listTeamSquad)
        /*if(recyclerViewAdapter1!=null )
        {
            Log.e("Key5"," ko null r")
        }*/
        var linearLayoutManager = LinearLayoutManager(this.context)

        recyclerView.adapter =recyclerViewAdapter1
        recyclerView.layoutManager =linearLayoutManager
    }
}