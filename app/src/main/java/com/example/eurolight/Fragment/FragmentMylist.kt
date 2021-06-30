package com.example.eurolight.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eurolight.Model
import com.example.eurolight.R


class FragmentMylist : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mylist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recyclerViewMyMatch :RecyclerView =view.findViewById(R.id.recyclerViewMyMatch)
        var recyclerViewMyMatchAdapter: RecyclerViewMyMatchAdapter = RecyclerViewMyMatchAdapter(Model.myMatchs)
        recyclerViewMyMatch.layoutManager = LinearLayoutManager(this.context)
        recyclerViewMyMatch.adapter=recyclerViewMyMatchAdapter

        var recyclerViewMyTeam:RecyclerView = view.findViewById(R.id.recyclerViewMyTeam)
        var recyclerViewMyTeamAdapter: RecyclerViewMyTeamAdapter = RecyclerViewMyTeamAdapter(Model.myTeams)
        recyclerViewMyTeam.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewMyTeam.adapter= recyclerViewMyTeamAdapter


    }


}