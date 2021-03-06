package com.example.todolist_ramkumartextiles.owners.views.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todolist_ramkumartextiles.R
import com.example.todolist_ramkumartextiles.MainActivity
import com.example.todolist_ramkumartextiles.di.AppModule
import com.example.todolist_ramkumartextiles.owners.views.fragments.AssignTaskFrag
import com.example.todolist_ramkumartextiles.owners.views.fragments.EmployeeInfoFrag
import com.example.todolist_ramkumartextiles.owners.views.fragments.MapsFrag
import com.example.todolist_ramkumartextiles.owners.views.fragments.StatusFrag
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_owners.*

class OwnersAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owners)

        bottom_nav.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)
        val startFrag = AssignTaskFrag()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, startFrag).commit()

        logout_owners.setOnClickListener {
            var sharedPreferences = AppModule(application).providesSharedPreferences(application)
            sharedPreferences.edit().putBoolean("KEY_OWNERS_LOGIN",false).apply()
            finish()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }

    private  val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->

        var selectedFragment: Fragment? = null

        when(item.itemId)
        {
            R.id.task ->{
                selectedFragment =
                    AssignTaskFrag()
            }
            R.id.status ->{
                selectedFragment =
                    StatusFrag()
            }
            R.id.location ->{
                selectedFragment =
                    MapsFrag()
            }
            R.id.people ->{
                selectedFragment =
                    EmployeeInfoFrag()
            }
        }

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment!!).commit()
        true
    }
}


