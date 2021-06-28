package com.example.eurolight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(),Comunicator {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var fragment_1 = FragmentTeam()
        supportFragmentManager.beginTransaction().replace(R.id.frl_main,fragment_1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
        navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.item1-> {

                    var fragment_1 = FragmentTeam()
                    supportFragmentManager.beginTransaction().replace(R.id.frl_main,fragment_1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.item2-> {
                    var fragment_2 = FragmentMatch()
                    supportFragmentManager.beginTransaction().replace(R.id.frl_main,fragment_2).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.item3-> Log.e("Key3","3")
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun loadData()
    {
        thread {
            Model.getData()

        }
    }

    override fun passData(nameTeam: String) {
        val bundle = Bundle()
        bundle.putString("nameTeam",nameTeam)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragment_2 = FragmentPlayer()
        fragment_2.arguments = bundle

        transaction.replace(R.id.frl_main,fragment_2).addToBackStack(null).commit()
    }

}

