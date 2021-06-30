package com.example.eurolight.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eurolight.MatchListener
import com.example.eurolight.Model
import com.example.eurolight.R

class FragmentMatch : Fragment(), MatchListener {

    lateinit var buttonAddtoWatchList : Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAddtoWatchList = view.findViewById(R.id.btn_addToWatchList)
        var recyclerView : RecyclerView = view.findViewById(R.id.recyclerViewMatch)
        var recyclerViewAdapter = RecyclerViewMatchAdapter(Model.listMatch, this)

        var linearLayoutManager = LinearLayoutManager(this.context)

        recyclerView.adapter= recyclerViewAdapter
        recyclerView.layoutManager = linearLayoutManager

        buttonAddtoWatchList.setOnClickListener{
            if(buttonAddtoWatchList.visibility==View.VISIBLE)
            {
                buttonAddtoWatchList.visibility=View.GONE
            }

            for(match in recyclerViewAdapter.getSelectedMatchs()) {
                if (match.isSelected) {
                    match.isSelected = false
                    Model.myMatchs.add(match)
                }
            }
            recyclerViewAdapter.notifyDataSetChanged()

        }
    }

    override fun onMatchAction(isSelected: Boolean) {
        if(isSelected)
        {
            buttonAddtoWatchList.visibility = View.VISIBLE
        }
        else
        {
            buttonAddtoWatchList.visibility=View.GONE
        }
    }




}