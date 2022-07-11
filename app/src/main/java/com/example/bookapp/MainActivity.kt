package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        navigationView = findViewById(R.id.navigationView)
        frameLayout = findViewById(R.id.frame)

        setUpToolbar()


        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.dashboard -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,DashBoardFragment())
                        .commit()
                    drawerLayout.closeDrawers()
                }
                R.id.favourites -> {
                    Toast.makeText(this@MainActivity, "Click on favourites", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.profile -> {
                    Toast.makeText(this@MainActivity, "Click on profile", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.aboutApp -> {
                    Toast.makeText(this@MainActivity, "Click on aboutApp", Toast.LENGTH_SHORT)
                        .show()
                }

            }
            return@setNavigationItemSelectedListener true
        }
    }


    fun setUpToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "ToolBar"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) (
                drawerLayout.openDrawer(GravityCompat.START)
                )

        return super.onOptionsItemSelected(item)
    }

}