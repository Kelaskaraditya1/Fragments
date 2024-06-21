package com.starkindustries.fragments.Activity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.starkindustries.fragments.Fragments.FragmentOne
import com.starkindustries.fragments.Fragments.FragmentSecond
import com.starkindustries.fragments.R
import com.starkindustries.fragments.databinding.ActivityBottomNavFragmentBinding

class BottomNavFragment : AppCompatActivity() {
    lateinit var binding:ActivityBottomNavFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bottom_nav_fragment)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_bottom_nav_fragment)
        binding.bottomNav.setOnNavigationItemSelectedListener(object:BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when(p0.itemId)
                {
                    R.id.fragment1->{
                        var manager:FragmentManager = supportFragmentManager
                        var fragmentTrasnaction:FragmentTransaction = manager.beginTransaction()
                        fragmentTrasnaction.replace(R.id.frame_layout, FragmentOne())
                        fragmentTrasnaction.commit()
                    }
                    R.id.fragment2->{
                        var manager:FragmentManager = supportFragmentManager
                        var fragmentTrasnaction:FragmentTransaction = manager.beginTransaction()
                        fragmentTrasnaction.replace(R.id.frame_layout, FragmentSecond())
                        fragmentTrasnaction.commit()
                    }
                }
                return true
            }
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}