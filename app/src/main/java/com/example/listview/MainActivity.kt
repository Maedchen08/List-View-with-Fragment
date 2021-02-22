package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener,
        OnNavigationListener {
    private lateinit var fragmentOne: FragmentOne
    private lateinit var fragmentTwo: FragmentTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAdd.setOnClickListener(this)
        buttonList.setOnClickListener(this)
        fragmentOne = FragmentOne.newInstance(this)
        fragmentTwo = FragmentTwo.newInstance(this)

    }

    companion object {
        const val ADD_ITEM_FRAGMENT_TAG = "ADD_ITEM_FRAGMENT_TAG"
        const val LIST_ITEM_FRAGMENT_TAG = "LIST_ITEM_FRAGMENT"

    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment).commit()
    }

//    fun gotToAddNav(view: View) {
//        fragmentOne = FragmentOne.newInstance(this)
//        switchFragment(fragmentOne)
//
//    }
//
//    fun goToListNav(view: View) {
//        fragmentTwo = FragmentTwo.newInstance(this)
//        switchFragment(fragmentTwo)
//    }

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

    override fun onClick(v: View?) {
        when(v){
            buttonAdd->{
                switchFragment(fragmentOne)
            }
            buttonList->{
                switchFragment(fragmentTwo)
            }
        }
    }


}
