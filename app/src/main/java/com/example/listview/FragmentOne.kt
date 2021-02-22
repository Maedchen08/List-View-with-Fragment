package com.example.listview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne(private val onNavigationListener: OnNavigationListener) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonCreate.setOnClickListener {
            val item = ItemData(
                    qty = etqty.text.toString().toInt(),
                    note = etnote.text.toString(),
                    itemName = etname.text.toString()
            )
            if (item != null) {
                onNavigationListener.addItem(item)
                Toast.makeText(
                        activity,
                        "Item : ${item.itemName} has been added",
                        Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) = FragmentOne(onNavigationListener)
    }
}