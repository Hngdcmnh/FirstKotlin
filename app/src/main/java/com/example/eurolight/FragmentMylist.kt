package com.example.eurolight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentMylist : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mylist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recyclerViewMyMatch :RecyclerView =view.findViewById(R.id.recyclerViewMyMatch)
        var recyclerViewMyMatchAdapter:RecyclerViewMyMatchAdapter = RecyclerViewMyMatchAdapter(Model.myMatchs)
        recyclerViewMyMatch.layoutManager = LinearLayoutManager(this.context)
        recyclerViewMyMatch.adapter=recyclerViewMyMatchAdapter


    }


}