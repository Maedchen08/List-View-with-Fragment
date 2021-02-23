package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
        OnNavigationListener {
    private lateinit var fragmentOne: FragmentOne
    private lateinit var fragmentTwo: FragmentTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        val fragmentOne = FragmentOne.newInstance(this)
        val fragmentTwo = FragmentTwo.newInstance(this)
        switchFragment(fragmentOne)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_add -> switchFragment(fragmentOne)
                R.id.nav_list -> switchFragment(fragmentTwo)
            }
            false
        }


    }

    companion object {
        const val ADD_ITEM_FRAGMENT_TAG = "ADD_ITEM_FRAGMENT_TAG"
        const val LIST_ITEM_FRAGMENT_TAG = "LIST_ITEM_FRAGMENT"

    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun menuItem() {
        fragmentOne = FragmentOne.newInstance(this)
        switchFragment(fragmentOne)
    }

    override fun showItems() {
        fragmentTwo = FragmentTwo.newInstance(this)
        switchFragment(fragmentTwo)
    }

    override fun addItem(item: ItemData) {
        ItemList.add(item)
    }




}
