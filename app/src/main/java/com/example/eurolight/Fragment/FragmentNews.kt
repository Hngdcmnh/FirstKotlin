package com.example.eurolight.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eurolight.Model
import com.example.eurolight.R

class FragmentNews : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recyclerViewNews:RecyclerView = view.findViewById(R.id.recyclerViewNews)
        var recyclerViewNewsAdapter = RecyclerViewNewsAdapter(Model.listNews)

        recyclerViewNews.layoutManager = LinearLayoutManager(this.context)

        recyclerViewNews.adapter= recyclerViewNewsAdapter

    }

}