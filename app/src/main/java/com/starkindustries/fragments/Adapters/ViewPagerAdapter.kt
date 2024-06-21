package com.starkindustries.fragments.Adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.starkindustries.fragments.Fragments.FragmentOne
import com.starkindustries.fragments.Fragments.FragmentSecond
class ViewPagerAdapter(context_:Context,manager_: FragmentManager):FragmentPagerAdapter(manager_)
{
    lateinit var context:Context
    init
    {
        this.context=context_
    }
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment
    {
        lateinit var fragment:Fragment
        if(position==0)
            fragment=FragmentOne()
        else if (position==1)
            fragment=FragmentSecond()
        return fragment
    }
    override fun getPageTitle(position: Int): CharSequence?
    {
        lateinit var name:String
        if(position==0)
            name="Fragment1"
        else if(position==1)
            name="Fragment2"
        return name
    }
}