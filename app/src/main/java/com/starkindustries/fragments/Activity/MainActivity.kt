package com.starkindustries.fragments.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.starkindustries.fragments.Fragments.FragmentOne
import com.starkindustries.fragments.Fragments.FragmentSecond
import com.starkindustries.fragments.R
import com.starkindustries.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
//        var fragmentManager:FragmentManager = supportFragmentManager
//        var transaction1:FragmentTransaction = fragmentManager.beginTransaction()
//        transaction1.add(R.id.framelayout, FragmentOne())
//        transaction1.commit()
        binding.fragment1Button.setOnClickListener()
        {
            var fragmentManager:FragmentManager = supportFragmentManager
            var transaction1:FragmentTransaction = fragmentManager.beginTransaction()
            transaction1.replace(R.id.framelayout, FragmentOne())
            transaction1.commit()
        }
        binding.fragment2Button.setOnClickListener()
        {
            var fragmentManager:FragmentManager = supportFragmentManager
            var transaction1:FragmentTransaction = fragmentManager.beginTransaction()
            transaction1.replace(R.id.framelayout,FragmentSecond())
            transaction1.commit()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}