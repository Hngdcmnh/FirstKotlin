package com.example.eurolight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.example.eurolight.Fragment.*
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

        // Set the first Fragment what you see when run app
        var fragment_4 = FragmentNews()
        supportFragmentManager.beginTransaction().replace(R.id.frl_main,fragment_4).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        // Change between 3 Fragments
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
                R.id.item3-> {
                    var fragment_3 = FragmentMylist()
                    supportFragmentManager.beginTransaction().replace(R.id.frl_main,fragment_3).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.item4-> {
                    var fragment_4 = FragmentNews()
                    supportFragmentManager.beginTransaction().replace(R.id.frl_main,fragment_4).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    // Toggle is the ||| button in the top left of actionbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //other thread for load data
    fun loadData()
    {
        thread {
            Model.getData()
        }
    }

    // pass data (name of team) from Fragment Team -> Fragment Player
    override fun passData(nameTeam: String) {
        val bundle = Bundle()
        bundle.putString("nameTeam",nameTeam)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragment_2 = FragmentPlayer()
        fragment_2.arguments = bundle

        transaction.replace(R.id.frl_main,fragment_2).addToBackStack(null).commit()
    }

}

