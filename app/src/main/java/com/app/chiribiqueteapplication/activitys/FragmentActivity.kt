package com.app.chiribiqueteapplication.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.app.chiribiqueteapplication.R
import com.app.chiribiqueteapplication.preference.SettingsFragment
import java.io.FileOutputStream

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val  fm: FragmentManager =supportFragmentManager
        val  ft: FragmentTransaction =fm.beginTransaction()

        return  when (item.itemId) {
            R.id.menu_preferences -> {
                val fragmentSetting = SettingsFragment()
                ft.replace(R.id.fragmentContainerView, fragmentSetting).commit()
                ft.addToBackStack(null)
                true
            }
            else -> {
                return true
            }
        }
    }
}