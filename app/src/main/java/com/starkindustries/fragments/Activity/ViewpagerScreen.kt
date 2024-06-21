package com.starkindustries.fragments.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.starkindustries.fragments.Adapters.ViewPagerAdapter
import com.starkindustries.fragments.R
import com.starkindustries.fragments.databinding.ActivityViewpagerScreenBinding

class ViewpagerScreen : AppCompatActivity() {
    lateinit var binding:ActivityViewpagerScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_viewpager_screen)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_viewpager_screen)
        var adapter:ViewPagerAdapter = ViewPagerAdapter(applicationContext,supportFragmentManager)
        binding.viewpager.adapter=adapter
        binding.tabLayout.setupWithViewPager(binding.viewpager)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}