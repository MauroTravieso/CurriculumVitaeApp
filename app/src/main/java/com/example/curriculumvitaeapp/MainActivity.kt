package com.example.curriculumvitaeapp

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.curriculumvitaeapp.ui.aboutme.AboutMeFragment
import com.example.curriculumvitaeapp.ui.contactdetails.ContactDetailsFragment
import com.example.curriculumvitaeapp.ui.home.HomeFragment
import com.example.curriculumvitaeapp.ui.workexperience.WorkExperienceFragment
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // Fragment
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    lateinit var  drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
         drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_aboutme, R.id.nav_workexperience,
                R.id.nav_contactdetails, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)

        // Fragment
        fmanager = supportFragmentManager
        tx = fmanager.beginTransaction()
        tx.add(R.id.frame1, HomeFragment())
        tx.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.nav_home -> {
                Toast.makeText(applicationContext, "Home Selected", Toast.LENGTH_LONG).show()
                true
            }

            R.id.nav_aboutme -> {
                Toast.makeText(applicationContext, "About Me Selected", Toast.LENGTH_LONG).show()
                true
            }

            R.id.nav_workexperience -> {
                Toast.makeText(applicationContext, "Work Experience Selected", Toast.LENGTH_LONG).show()
                true
            }

            R.id.nav_contactdetails -> {
                Toast.makeText(applicationContext, "Contact Details Selected", Toast.LENGTH_LONG).show()
                true
            }

            R.id.nav_share -> {
                Toast.makeText(applicationContext, "Share Selected", Toast.LENGTH_LONG).show()
                true
            }

            R.id.nav_send -> {
                Toast.makeText(applicationContext, "Send Selected", Toast.LENGTH_LONG).show()
                true
            }

            else -> {
                val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
                drawer.closeDrawer(GravityCompat.START)
                true
            }
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }

    // Fragments
    fun home(view: View) {
        tx = fmanager.beginTransaction()
        // when the user selects the Home button, we are replacing the HomeFragment
        tx.replace(R.id.frame1, HomeFragment())
        tx.commit()
    }

    fun aboutMe(view: View) {
        tx = fmanager.beginTransaction()
        // when the user selects the Home button, we are replacing the HomeFragment
        tx.replace(R.id.frame1, AboutMeFragment())
        tx.commit()
    }

    fun workExperience(view: View) {
        tx = fmanager.beginTransaction()
        // when the user selects the Home button, we are replacing the HomeFragment
        tx.replace(R.id.frame1, WorkExperienceFragment())
        tx.commit()
    }

    fun contactUs(view: View) {
        tx = fmanager.beginTransaction()
        // when the user selects the Home button, we are replacing the HomeFragment
        tx.replace(R.id.frame1, ContactDetailsFragment())
        tx.commit()
    }
}



