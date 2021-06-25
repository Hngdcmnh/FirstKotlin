package com.example.eurolight

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.thread


class Fragment_player : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        var recyclerView : RecyclerView = view.findViewById(R.id.RecyclerViewPlayer)
        var recyclerViewPlayerAdapter = RecyclerViewPlayerAdapter(Model.listTeamSquad[0].players)

        var linearLayoutManager = LinearLayoutManager(this.context)

        recyclerView.adapter =recyclerViewPlayerAdapter
        recyclerView.layoutManager =linearLayoutManager
    }
}