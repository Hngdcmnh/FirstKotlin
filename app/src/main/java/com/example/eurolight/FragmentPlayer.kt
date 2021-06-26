package com.example.eurolight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentPlayer : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var nameTeam = arguments?.getString("nameTeam")

        var recyclerView : RecyclerView = view.findViewById(R.id.RecyclerViewPlayer)
        var recyclerViewPlayerAdapter = RecyclerViewPlayerAdapter(Model.listTeam[nameTeam?.toInt()!!].players)

//        var linearLayoutManager = LinearLayoutManager(this.context)
        var linearLayoutManager = GridLayoutManager(this.context,2)

        recyclerView.adapter =recyclerViewPlayerAdapter
        recyclerView.layoutManager =linearLayoutManager
    }
}