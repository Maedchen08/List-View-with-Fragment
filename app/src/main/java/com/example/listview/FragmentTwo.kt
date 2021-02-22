package com.example.listview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_two.*

class FragmentTwo(private val onNavigationListener: OnNavigationListener) : Fragment() {

    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var layoutManager : RecyclerView.LayoutManager?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply{
            //set a LinearLayoutManager to handle ANDROID
            layoutManager = LinearLayoutManager(activity)
            //set the custom adapter to the recycelview
            adapter = RecyclerAdapter()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(onNavigationListener:OnNavigationListener) =
                FragmentTwo(onNavigationListener)
    }
}