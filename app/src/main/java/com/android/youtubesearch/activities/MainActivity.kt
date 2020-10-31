package com.android.youtubesearch.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.SearchEvent
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import com.android.youtubesearch.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu,menu)

        val mMenuItem : MenuItem = menu!!.findItem(R.id.action_search)

        val mSearchView :SearchView = mMenuItem.actionView as SearchView
        mSearchView.queryHint = "Search Youtube Videos"

        mSearchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }
*/
}