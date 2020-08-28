package com.chong.widget.verticalviewpager.example.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import java.util.ArrayList

class ContentFragmentAdapter(fm: FragmentManager, fragments: List<Fragment>) : FragmentPagerAdapter(fm) {
    private var fragments = ArrayList<Fragment>()

    init {
        this.fragments = fragments as ArrayList<Fragment>
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return (fragments[position] as ContentFragment).title
    }

    class Holder(private val manager: FragmentManager) {
        private val fragments = ArrayList<Fragment>()

        fun add(f: Fragment): Holder {
            fragments.add(f)
            return this
        }

        fun set(): ContentFragmentAdapter {
            return ContentFragmentAdapter(manager, fragments)
        }
    }

}
