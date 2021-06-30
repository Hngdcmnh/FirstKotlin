package com.example.eurolight.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eurolight.*


class FragmentTeam : Fragment() {

    private lateinit var comunicator: Comunicator
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recyclerView : RecyclerView = view.findViewById(R.id.recyclerViewTeam)
        var recyclerViewAdapter1 = RecyclerViewTeamAdapter(Model.listTeam, { (activity as MainActivity).passData(it) })

        /*if(recyclerViewAdapter1!=null )
        {
            Log.e("Key5"," ko null r")
        }*/
        var linearLayoutManager = LinearLayoutManager(this.context)

        recyclerView.adapter =recyclerViewAdapter1
        recyclerView.layoutManager =linearLayoutManager
    }

    /*override fun passData2(nameTeam2: String) {
        (activity as MainActivity).passData(nameTeam2)
    }*/

    /*override fun passData2(nameTeam2: String) {
        comunicator = activity as MainActivity
        comunicator.passData(nameTeam2)
    }*/
}